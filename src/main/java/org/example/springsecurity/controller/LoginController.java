package org.example.springsecurity.controller;

import lombok.RequiredArgsConstructor;
import org.example.springsecurity.dto.AccountLoginDto;
import org.example.springsecurity.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final AccountService accountService;

    @GetMapping("/login")
    public String login() {
        return "basic/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute AccountLoginDto loginDto) {
        Boolean islogin = accountService.isValidUser(loginDto);
        if(islogin) {
            return "redirect:/";
        }
        return "redirect:/login";
    }
}
