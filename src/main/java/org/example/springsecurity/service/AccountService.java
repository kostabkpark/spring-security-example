package org.example.springsecurity.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springsecurity.domain.Account;
import org.example.springsecurity.dto.AccountLoginDto;
import org.example.springsecurity.repository.AccountRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AccountService implements UserDetailsService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if(account == null) {
            throw new UsernameNotFoundException(username);
        }
        return User.builder()
                .username(account.getUsername())
                .password("{noop}" + account.getPassword())
                .roles(account.getRole())
                .build();
    }

    public Account addAccount(Account account) {
        Account findAccount = accountRepository.findByUsername(account.getUsername());
        if(findAccount == null) {
            account.changePassword(account.getPassword(), encoder);
            account.setRole("USER");
            findAccount = accountRepository.save(account);
        } else {
            throw new IllegalArgumentException("Account already exists");
        }
        return findAccount;
    }

    public Boolean isValidUser(AccountLoginDto loginDto) {
        Account account = accountRepository.findByUsername(loginDto.getUsername());
        if(account != null && account.checkPassword(loginDto.getPassword(), encoder)) {
            return true;
        }
        return false;
    }
}
