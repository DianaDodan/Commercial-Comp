package com.cc.ccbackend.service;

import com.cc.ccbackend.domain.Login;
import com.cc.ccbackend.repo.LoginRepo;
import java.security.SecureRandom;
import java.util.Base64;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginService {
    private final LoginRepo loginRepo;
    private final PasswordEncoder passwordEncoder;
    public void createLogin(Login login) {
        String salt = generateSalt();
        login.setPassword(passwordEncoder.encode(login.getPassword() + salt));
        loginRepo.createLogin(login, salt);
    }

    private String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    public boolean authenticate(Login login) {
        Login existingLogin = loginRepo.authenticate(login.getUsername());
        return passwordEncoder.matches(login.getPassword() + existingLogin.getSalt(), existingLogin.getPassword());
    }
}
