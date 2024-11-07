package org.example.springsecurity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountLoginDto {
    private String username;
    private String password;
}
