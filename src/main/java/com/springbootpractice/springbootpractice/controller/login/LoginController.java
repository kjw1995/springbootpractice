package com.springbootpractice.springbootpractice.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String goLogin() {
        return "/login";
    }
    
}
