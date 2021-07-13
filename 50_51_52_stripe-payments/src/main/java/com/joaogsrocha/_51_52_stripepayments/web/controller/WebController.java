package com.joaogsrocha._51_52_stripepayments.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class WebController {

    @Value("${stripe.public.key}")
    private String stripePublicKey;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("stripePublicKey", stripePublicKey);
        return "index";
    }
}
