package com.hg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**public class HelloController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg","hellospringmvc");
        mv.setViewName("Hello");
        return mv;
    }

}
*/
@Controller

public class HelloController{
    @RequestMapping("/h")
    public String sayHello(Model model){
        model.addAttribute("msg","hello,springmvc");
        return "hello";

    }
}