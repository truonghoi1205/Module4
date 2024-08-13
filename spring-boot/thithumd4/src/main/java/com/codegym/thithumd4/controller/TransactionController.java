package com.codegym.thithumd4.controller;

import com.codegym.thithumd4.dto.TransactionDto;
import com.codegym.thithumd4.model.Customer;
import com.codegym.thithumd4.model.ServiceType;
import com.codegym.thithumd4.model.Transaction;
import com.codegym.thithumd4.service.ICustomerService;
import com.codegym.thithumd4.service.ITransactionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/list")
public class TransactionController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ITransactionService transactionService;

    @ModelAttribute("customers")
    public Iterable<Customer> showAllCustomer() {
        return customerService.findAll();
    }

    @GetMapping("")
    public String showAllTransaction(Model model,
                                     @RequestParam(value = "customerName", required = false) String customerName,
                                     @RequestParam(value = "serviceType", required = false) ServiceType serviceType) {
        Iterable<Transaction> transactions = transactionService.searchTransactions(customerName,serviceType);
        model.addAttribute("transactions", transactions);
        model.addAttribute("customerName",customerName);
        model.addAttribute("serviceType", serviceType != null ? serviceType.name() : "");
        return "index";
    }

    @GetMapping("/create")
    public String showFormCreateTransaction(Model model) {
        model.addAttribute("transactionDto", new TransactionDto());
        return "create";
    }

    @PostMapping("/create")
    public String createStudent(@Validated @ModelAttribute TransactionDto transactionDto,
                                BindingResult result,
                                Model model,
                                RedirectAttributes redirect) {
        model.addAttribute("isSubmitted", true);
        if (result.hasFieldErrors()) {
            model.addAttribute("transactionDto", transactionDto);
            return "create";
        }

        if (transactionService.checkTransactionCodeExists(transactionDto.getCode())) {
            model.addAttribute("transactionDto", transactionDto);
            result.rejectValue("code", "error.code", "Mã giao dịch đã tồn tại");
            return "create";
        }
        Transaction transaction = new Transaction();
        BeanUtils.copyProperties(transactionDto, transaction);
        transactionService.save(transaction);
        redirect.addFlashAttribute("noti", "Thêm mới thành công!");
        return "redirect:/list";
    }

    @GetMapping("/{id}/detail")
    private String findTransactionById(@PathVariable Long id,
                                       Model model) {
        Transaction transaction = transactionService.findTransactionById(id);
        model.addAttribute("transaction",transaction);
        return "detail";
    }

    @PostMapping("/{id}/detail/delete")
    public String deleteStudent(@PathVariable Long id,
                                @ModelAttribute Transaction transaction,
                                RedirectAttributes redirect) {
        transactionService.deleteById(id);
        redirect.addFlashAttribute("noti", "Xóa thành công!");
        return "redirect:/list";
    }

}
