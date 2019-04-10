package com.rimore.rimore.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/")
    public String homepage(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }
}