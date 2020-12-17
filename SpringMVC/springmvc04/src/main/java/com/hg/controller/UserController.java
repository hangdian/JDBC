package com.hg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping("/t3")
    public String test1(String name, Model model){
        System.out.println("jieshoudao");
        model.addAttribute("msg",name);
        return "test";
    }
}
