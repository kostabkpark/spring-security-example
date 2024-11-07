package org.example.springsecurity.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 10)
    private String username;
    private String password;
    @Column(length = 10)
    private String role;

    public void changePassword(String password) {
        this.password = "{noop}" + password;
    }
}
