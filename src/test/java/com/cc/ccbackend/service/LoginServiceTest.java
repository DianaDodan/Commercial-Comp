package com.cc.ccbackend.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cc.ccbackend.domain.Login;
import com.cc.ccbackend.repo.LoginRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
public class LoginServiceTest {

    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private LoginRepo loginRepo;
    @InjectMocks
    private LoginService onTest;

    @Test
    public void createLogin_whenNewUser_thenCreateLogin() {
        //given
        Login login = new Login("abc", "abc");
        //when
        when(passwordEncoder.encode(any())).thenReturn("abc");
        //then
        onTest.createLogin(login);
        verify(loginRepo).createLogin(eq(login), any());
    }

    @Test
    public void authenticate_whenUserExists_thenReturnTrue() {
        //given
        Login login = new Login("abc", "abc");

        //when
        when(loginRepo.authenticate(login.getUsername())).thenReturn(login);
        when(passwordEncoder.matches(any(), any())).thenReturn(true);

        //then
        assertTrue(onTest.authenticate(login));
    }

    @Test
    public void authenticate_whenUserDoesNotExist_thenReturnFalse() {
        //given
        Login login = new Login("abc", "abc");

        //when
        when(loginRepo.authenticate(login.getUsername())).thenReturn(login);
        when(passwordEncoder.matches(any(), any())).thenReturn(false);

        //then
        assertFalse(onTest.authenticate(login));
    }
}
