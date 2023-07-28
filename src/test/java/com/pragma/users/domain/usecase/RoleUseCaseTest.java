package com.pragma.users.domain.usecase;

import com.pragma.users.domain.model.Role;
import com.pragma.users.domain.spi.IRolePersistencePort;
import com.pragma.users.manager.ManagerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RoleUseCaseTest {

    private RoleUseCase roleUseCase;

    @Mock
    private IRolePersistencePort rolePersistencePort;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        roleUseCase = new RoleUseCase(rolePersistencePort);
    }

    @Test
    void getRoleById_shouldReturnRoleFromPersistencePort() {
        // Arrange
        int roleId = 1;
        Role expectedRole = ManagerFactory.createRole();
        when(rolePersistencePort.getRoleById(roleId)).thenReturn(expectedRole);

        // Act
        Role resultRole = roleUseCase.getRoleById(roleId);

        // Assert
        assertEquals(expectedRole, resultRole);
    }

    @Test
    void getRoleByName_shouldReturnRoleFromPersistencePort() {
        // Arrange
        String roleName = "ADMIN";
        Role expectedRole = ManagerFactory.createRole();
        when(rolePersistencePort.getRoleByName(roleName)).thenReturn(expectedRole);

        // Act
        Role resultRole = roleUseCase.getRoleByName(roleName);

        // Assert
        assertEquals(expectedRole, resultRole);
    }
}
