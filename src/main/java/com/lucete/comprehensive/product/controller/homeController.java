package com.lucete.comprehensive.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {

    @GetMapping("/index")
    public String getHome() {

        return "/index";
    }
}
