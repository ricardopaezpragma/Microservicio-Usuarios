package com.pragma.users.domain.usecase;

import com.pragma.users.domain.model.User;
import com.pragma.users.domain.spi.IUserPersistencePort;
import com.pragma.users.manager.ManagerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserUseCaseTest {

    private UserUseCase userUseCase;

    @Mock
    private IUserPersistencePort userPersistencePort;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        userUseCase = new UserUseCase(userPersistencePort);
    }

    @Test
    void saveUser_shouldCallUserPersistencePortSaveUser() {
        // Arrange
        User user = ManagerFactory.createUser();
        when(userPersistencePort.saveUser(user)).thenReturn(user);

        // Act
        User result = userUseCase.saveUser(user);

        // Assert
        verify(userPersistencePort, times(1)).saveUser(user);
        assertEquals(user, result);
    }

    @Test
    void getUserByEmail_shouldCallUserPersistencePortGetUserByEmail() {
        // Arrange
        String email = "test@example.com";
        User user = ManagerFactory.createUser();
        when(userPersistencePort.getUserByEmail(email)).thenReturn(user);

        // Act
        User result = userUseCase.getUserByEmail(email);

        // Assert
        verify(userPersistencePort, times(1)).getUserByEmail(email);
        assertEquals(user, result);
    }

    @Test
    void getById_shouldCallUserPersistencePortGetById() {
        // Arrange
        int userId = 123;
        User user = ManagerFactory.createUser();
        when(userPersistencePort.getById(userId)).thenReturn(user);

        // Act
        User result = userUseCase.getById(userId);

        // Assert
        verify(userPersistencePort, times(1)).getById(userId);
        assertEquals(user, result);
    }
}
