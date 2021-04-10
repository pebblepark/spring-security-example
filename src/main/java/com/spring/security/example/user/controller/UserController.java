package com.spring.security.example.user.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.security.example.user.service.UserService;

@Controller
public class UserController {

    private final UserService userSerivce;

    public UserController(UserService userService) {
        this.userSerivce = userService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "loginForm";
    }

    @GetMapping("/main")
    public ModelAndView mainPage(ModelAndView mv, Authentication authentication) {
        String name = authentication.getName();
        mv.addObject("name", name);
        return mv;
    }

    @GetMapping("/admin")
    public ModelAndView adminPage(ModelAndView mv, Authentication authentication) {
        String name = authentication.getName();
        mv.addObject("name", name);
        return mv;
    }


}
