package com.codegym.customerprovincemanagement.controller;

import com.codegym.customerprovincemanagement.model.Customer;
import com.codegym.customerprovincemanagement.model.Province;
import com.codegym.customerprovincemanagement.service.customer.ICustomerService;
import com.codegym.customerprovincemanagement.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProvinceService provinceService;

    @ModelAttribute("provinces")
    private Iterable<Province> showAllProvince() {
        Iterable<Province> provinces = provinceService.findAll();
        return provinces;
    }


    @GetMapping("")
    public String showAll(Model model,
                          @RequestParam(defaultValue = "0") int page) {
        Page<Customer> customers = customerService.findAll(PageRequest.of(page,2));
        model.addAttribute("customers", customers);
        return "list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Customer customer,
                         RedirectAttributes redirect) {
        customerService.save(customer);
        redirect.addFlashAttribute("noti","Thêm mới thành công!!");
        return "redirect:/customers";
    }

    @GetMapping("{id}/update")
    public String showFormUpdate(Model model,
                                 @PathVariable Long id) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "update";
    }

    @PostMapping("{id}/delete")
    public String delete(@PathVariable Long id,
                         RedirectAttributes redirect) {
        customerService.deleteById(id);
        redirect.addFlashAttribute("noti","Xóa thành công!!");
        return "redirect:/customers";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Customer customer,
                         RedirectAttributes redirect) {
        customerService.save(customer);
        redirect.addFlashAttribute("noti","Sửa thành công!!");
        return "redirect:/customers";
    }
}
