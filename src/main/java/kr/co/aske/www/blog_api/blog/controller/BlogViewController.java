package kr.co.aske.www.blog_api.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogViewController {
    @GetMapping("/view/blog")
    public ModelAndView goBlog(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view/blog/blog");
        return modelAndView;
    }
}
