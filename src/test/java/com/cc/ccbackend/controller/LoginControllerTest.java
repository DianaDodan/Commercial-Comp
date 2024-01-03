package com.cc.ccbackend.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.cc.ccbackend.domain.Login;
import com.cc.ccbackend.service.LoginService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
public class LoginControllerTest {

    @Mock
    private LoginService loginService;
    @InjectMocks
    private LoginController onTest;

    @Test
    public void authenticate_whenLoginIsValid_thenReturnOkStatusCode() {
        //given
        Login login = new Login();

        //when
        when(loginService.authenticate(login)).thenReturn(true);

        //then
        assertEquals(HttpStatus.OK, onTest.authenticate(login).getStatusCode());
    }

    @Test
    public void authenticate_whenLoginIsNotValid_thenReturnBadRequestStatusCode() {
        //given
        Login login = new Login();

        //when
        when(loginService.authenticate(login)).thenReturn(false);

        //then
        assertEquals(HttpStatus.BAD_REQUEST, onTest.authenticate(login).getStatusCode());
    }
}
