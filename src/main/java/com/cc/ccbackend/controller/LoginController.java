package com.cc.ccbackend.controller;

import com.cc.ccbackend.domain.Login;
import com.cc.ccbackend.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<?> authenticate(@RequestBody Login login) {
        if (!loginService.authenticate(login)) {
            return ResponseEntity.badRequest().body("Invalid password.");
        }
        return ResponseEntity.ok().build();
    }
}
