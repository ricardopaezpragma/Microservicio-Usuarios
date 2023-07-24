package com.pragma.users.application.handler;

import com.pragma.users.application.dto.UserDto;
import com.pragma.users.application.mapper.UserMapper;
import com.pragma.users.domain.api.IUserServicePort;
import com.pragma.users.domain.model.User;
import com.pragma.users.manager.ManagerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class UserHandlerTest {
    private UserHandler userHandler;

    @Mock
    private IUserServicePort userServicePort;

    @Mock
    private UserMapper userMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        userHandler = new UserHandler(userServicePort, userMapper);
    }

    @Test
    void getUserByEmail_existingUser_shouldReturnMappedUserDto() {
        // Arrange
        String email = "test@example.com";
        User user = ManagerFactory.createUser();
        UserDto userDto = new UserDto();
        when(userServicePort.getUserByEmail(email)).thenReturn(user);
        when(userMapper.userToUserDto(user)).thenReturn(userDto);

        // Act
        UserDto result = userHandler.getUserByEmail(email);

        // Assert
        assertEquals(userDto, result);
    }

    @Test
    void saveUser_shouldCallUserServicePortSaveUserAndReturnMappedUserDto() {
        // Arrange
        UserDto userDto = new UserDto();
        User user = ManagerFactory.createUser();
        when(userMapper.userDtoToUser(userDto)).thenReturn(user);
        when(userServicePort.saveUser(user)).thenReturn(user);
        when(userMapper.userToUserDto(user)).thenReturn(userDto);

        // Act
        UserDto result = userHandler.saveUser(userDto);

        // Assert
        assertEquals(userDto, result);
        verify(userServicePort, times(1)).saveUser(user);
    }

    @Test
    void getById_existingUser_shouldReturnMappedUserDto() {
        // Arrange
        int userId = 123;
        User user = ManagerFactory.createUser();
        UserDto userDto = new UserDto();
        when(userServicePort.getById(userId)).thenReturn(user);
        when(userMapper.userToUserDto(user)).thenReturn(userDto);

        // Act
        UserDto result = userHandler.getById(userId);

        // Assert
        assertEquals(userDto, result);
    }
}






