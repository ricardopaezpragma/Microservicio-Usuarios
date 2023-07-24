package com.pragma.users.infrastructure.exception;

import lombok.Getter;

@Getter
public class UserException extends RuntimeException {
    public UserException(String message) {

        super("The user with "+message+" is not found");
    }
}
