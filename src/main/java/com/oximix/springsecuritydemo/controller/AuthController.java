package com.oximix.springsecuritydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController("/auth")
public class AuthController {

    @GetMapping("login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("success")
    public String getSuccessPage() {
        return "success";
    }
}
