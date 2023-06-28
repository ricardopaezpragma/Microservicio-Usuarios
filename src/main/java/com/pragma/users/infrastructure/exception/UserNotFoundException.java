package com.pragma.users.infrastructure.exception;

import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super();
    }
}
