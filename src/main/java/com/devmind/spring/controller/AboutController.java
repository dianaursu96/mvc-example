package com.devmind.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class AboutController {
    @RequestMapping("/about")
    public String aboutPage() {
        return "about"; // Returns the name of the view file (e.g., about.html)
    }
}
