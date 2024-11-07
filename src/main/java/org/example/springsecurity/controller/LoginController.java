package org.example.springsecurity.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springsecurity.dto.AccountLoginDto;
import org.example.springsecurity.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {
    private final AccountService accountService;

    @GetMapping("/login")
    public String login() {
        return "basic/login";
    }

//    @PostMapping("/login")
//    public String login(@ModelAttribute AccountLoginDto loginDto, Principal principal) {
//        log.info("loginDto : {}", loginDto);
//        Boolean islogin = accountService.isValidUser(loginDto, principal);
//        log.info("islogin : {}", islogin);
//        if(islogin) {
//            return "redirect:/";
//        }
//        return "redirect:/login";
//    }
}
