package com.pragma.users.application.handler;

import com.pragma.users.application.dto.UserDto;
public interface IUserHandler {
    UserDto getUserByEmail(String email);
    UserDto saveUser(UserDto userDto);
    UserDto getById(int userId);
}
