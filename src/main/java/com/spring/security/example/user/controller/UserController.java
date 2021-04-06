package com.spring.security.example.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.security.example.user.dao.User;
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
    public String mainPage() {
	return "main";
    }
    

}
