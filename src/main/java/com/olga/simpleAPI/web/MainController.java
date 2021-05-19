package com.olga.simpleAPI.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index1() {
        return "Hallo";
    }

    @GetMapping("/index")
    public String index2() {
        return "Hallo";
    }
}
