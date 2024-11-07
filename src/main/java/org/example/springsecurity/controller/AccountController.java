package org.example.springsecurity.controller;

import lombok.RequiredArgsConstructor;
import org.example.springsecurity.domain.Account;
import org.example.springsecurity.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/accounts/new")
    public String newAccount() {
        return "accounts/new";
    }

    @PostMapping("/accounts/new")
    public String newAccount(@ModelAttribute Account account) {
        Account saveAccount = accountService.addAccount(account);
        return "redirect:/login";
    }
}
