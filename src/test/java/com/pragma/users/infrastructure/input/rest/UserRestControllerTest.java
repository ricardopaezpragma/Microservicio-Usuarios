package com.pragma.users.infrastructure.input.rest;


import com.pragma.users.application.dto.UserDto;
import com.pragma.users.application.handler.IUserHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserRestControllerTest {

    @InjectMocks
    private UserRestController userRestController;

    @Mock
    private IUserHandler userHandler;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getUserByEmail_existingUser_shouldReturnUserDtoWith200Status() {
        // Arrange
        String email = "test@example.com";
        UserDto userDto = new UserDto();
        when(userHandler.getUserByEmail(email)).thenReturn(userDto);

        // Act
        ResponseEntity<UserDto> response = userRestController.getUserByEmail(email);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userDto, response.getBody());
    }

    @Test
    void getById_existingUser_shouldReturnUserDtoWith200Status() {
        // Arrange
        int userId = 123;
        UserDto userDto = new UserDto();
        when(userHandler.getById(userId)).thenReturn(userDto);

        // Act
        ResponseEntity<UserDto> response = userRestController.getById(userId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userDto, response.getBody());
    }

    @Test
    void saveUser_validUserDto_shouldReturnUserDtoWith201Status() {
        // Arrange
        UserDto userDto = new UserDto();
        UserDto savedUserDto = new UserDto();
        when(userHandler.saveUser(userDto)).thenReturn(savedUserDto);

        // Act
        ResponseEntity<UserDto> response = userRestController.saveUser(userDto);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(savedUserDto, response.getBody());
    }
}
