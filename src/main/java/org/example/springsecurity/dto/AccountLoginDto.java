package org.example.springsecurity.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountLoginDto {
    private String username;
    private String password;
}
