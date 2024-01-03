package com.cc.ccbackend.exception;

public class UsernameNotFoundException extends RuntimeException{
    public UsernameNotFoundException(String username) {
        super(String.format("Employee with username: %s does not exist.",username));
    }
}
