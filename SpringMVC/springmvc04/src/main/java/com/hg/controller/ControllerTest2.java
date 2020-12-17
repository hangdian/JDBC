package com.hg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;

@Controller
public class ControllerTest2 {
    @RequestMapping("/t2")
    public  String test1(Model model  ){
        model.addAttribute("msg","againHello");
        return "test";

    }
}
