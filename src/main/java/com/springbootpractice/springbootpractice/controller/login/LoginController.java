package com.springbootpractice.springbootpractice.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.springbootpractice.springbootpractice.common.url.commonUrl;

@Controller
public class LoginController {

    @GetMapping(value = commonUrl.LOGIN_URI)
    public String goLogin() {
        return "/login";
    }
    
}
