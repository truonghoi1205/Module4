package com.codegym.shoppingcart.controller;

import com.codegym.shoppingcart.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShoppingController {
    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart(@SessionAttribute("cart") Cart cart) {
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart", cart);
        modelAndView.addObject("countItem", cart.countItemQuantity());
        return modelAndView;
    }

    @PostMapping("/checkout")
    public String checkout(@SessionAttribute("cart") Cart cart) {
        cart.getProducts().clear();
        return "checkout";
    }
}