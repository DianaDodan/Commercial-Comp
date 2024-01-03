package com.cc.ccbackend.domain;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Login {
    private String username;
    private String password;
    private String salt;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
