package com.pragma.users.infrastructure.exception;

public class RoleException extends RuntimeException{
    public RoleException(String message) {
        super("The role with "+message+" is not found");
    }
}
