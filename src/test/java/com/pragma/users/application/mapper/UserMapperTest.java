package com.pragma.users.application.mapper;

import static org.junit.jupiter.api.Assertions.*;

import com.pragma.users.application.dto.UserDto;
import com.pragma.users.application.handler.IRoleHandler;
import com.pragma.users.domain.model.User;
import com.pragma.users.manager.ManagerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserMapperTest {

    @Mock
    private IRoleHandler roleHandler;

    @InjectMocks
    private UserMapper userMapper = new UserMapper() {
        @Override
        public User userDtoToUser(UserDto userDto) {
            return ManagerFactory.createUser();
        }

        @Override
        public UserDto userToUserDto(User user) {
            UserDto userDto=new UserDto();
            userDto.setRole("ROLE_NAME");
            return userDto;
        }
    };

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void userDtoToUser_shouldMapFieldsCorrectly() {
        // Arrange
        UserDto userDto = new UserDto();
        userDto.setRole("ROLE_NAME");

        // Act
        User user = userMapper.userDtoToUser(userDto);

        // Assert
        assertEquals(1, user.getRoleId());
    }

    @Test
    void userToUserDto_shouldMapFieldsCorrectly() {
        // Arrange
        User user = ManagerFactory.createUser();
        user.setRoleId(123);

        // Act
        UserDto userDto = userMapper.userToUserDto(user);

        // Assert
        assertEquals("ROLE_NAME", userDto.getRole());
    }
}
