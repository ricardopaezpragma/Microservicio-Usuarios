package com.pragma.users.infrastructure.output.jpa.adapter;

import com.pragma.users.domain.model.User;
import com.pragma.users.infrastructure.exception.UserException;
import com.pragma.users.infrastructure.output.jpa.entity.UserEntity;
import com.pragma.users.infrastructure.output.jpa.mapper.UserEntityMapper;
import com.pragma.users.infrastructure.output.jpa.repository.UserRepository;
import com.pragma.users.manager.ManagerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class UserJpaAdapterTest {
    private UserJpaAdapter userJpaAdapter;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserEntityMapper userEntityMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        userJpaAdapter = new UserJpaAdapter(userRepository, userEntityMapper);
    }

    @Test
    void saveUser_shouldCallUserRepositorySaveAndFlush() {
        // Arrange
        User user = ManagerFactory.createUser();
        UserEntity userEntity = ManagerFactory.createUserEntity();
        when(userEntityMapper.toEntity(user)).thenReturn(userEntity);
        when(userEntityMapper.toUser(userEntity)).thenReturn(user);
        when(userRepository.saveAndFlush(userEntity)).thenReturn(userEntity);

        // Act
        User result = userJpaAdapter.saveUser(user);

        // Assert
        verify(userRepository, times(1)).saveAndFlush(userEntity);
        assertEquals(user, result);
    }

    @Test
    void getUserByEmail_existingEmail_shouldReturnMappedUser() {
        // Arrange
        String email = "test@example.com";
        UserEntity userEntity = new UserEntity();
        User user = ManagerFactory.createUser();
        when(userRepository.findOneByEmail(email)).thenReturn(Optional.of(userEntity));
        when(userEntityMapper.toUser(userEntity)).thenReturn(user);

        // Act
        User result = userJpaAdapter.getUserByEmail(email);

        // Assert
        assertEquals(user, result);
    }

    @Test
    void getUserByEmail_nonExistingEmail_shouldThrowUserNotFoundException() {
        // Arrange
        String email = "nonexistent@example.com";
        when(userRepository.findOneByEmail(email)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(UserException.class, () -> userJpaAdapter.getUserByEmail(email));
    }

    @Test
    void getById_existingUser_shouldReturnMappedUser() {
        // Arrange
        int userId = 123;
        UserEntity userEntity = new UserEntity();
        User user = ManagerFactory.createUser();
        when(userRepository.findById(userId)).thenReturn(Optional.of(userEntity));
        when(userEntityMapper.toUser(userEntity)).thenReturn(user);

        // Act
        User result = userJpaAdapter.getById(userId);

        // Assert
        assertEquals(user, result);
    }

    @Test
    void getById_nonExistingUser_shouldThrowUserNotFoundException() {
        // Arrange
        int userId = 123;
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(UserException.class, () -> userJpaAdapter.getById(userId));
    }
}



