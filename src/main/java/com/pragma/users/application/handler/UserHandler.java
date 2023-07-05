package com.pragma.users.application.handler;

import com.pragma.users.application.dto.UserDto;
import com.pragma.users.application.mapper.UserMapper;
import com.pragma.users.domain.api.IUserServicePort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserHandler implements IUserHandler {
    private final IUserServicePort userServicePort;
    private final UserMapper userMapper;

    @Override
    public UserDto getUserByEmail(String email) {
        return userMapper.userToUserDto(userServicePort.getUserByEmail(email));
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        return userMapper.userToUserDto(
                userServicePort.saveUser(
                        userMapper.userDtoToUser(userDto)
                )
        );
    }

    @Override
    public UserDto getById(int userId) {
        return userMapper.userToUserDto(userServicePort.getById(userId));
    }
}
