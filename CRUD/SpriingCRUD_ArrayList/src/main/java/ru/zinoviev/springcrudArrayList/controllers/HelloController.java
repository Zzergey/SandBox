package ru.zinoviev.springcrudArrayList.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/")
    public String helloPage(Model model){
        model.addAttribute("hello", "HI!");

        return "/hello/indexPage";
    }

}
