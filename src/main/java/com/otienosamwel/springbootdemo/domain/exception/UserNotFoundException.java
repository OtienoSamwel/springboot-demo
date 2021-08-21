package com.otienosamwel.springbootdemo.domain.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(long userId) {
        super("user with id " + userId + " not found");
    }
}
