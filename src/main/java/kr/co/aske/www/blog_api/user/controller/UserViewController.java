package kr.co.aske.www.blog_api.user.controller;

import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserViewController {
    @GetMapping("/view/user")
    public ModelAndView UserPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello");
        return modelAndView;
    }

    @GetMapping("/view/user/login")
    public ModelAndView UserLoginPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view/user/login");
        return modelAndView;
    }

}
