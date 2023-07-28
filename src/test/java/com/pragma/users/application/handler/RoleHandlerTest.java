package com.pragma.users.application.handler;

import com.pragma.users.application.dto.RoleDto;
import com.pragma.users.application.mapper.RoleMapper;
import com.pragma.users.domain.api.IRoleServicePort;
import com.pragma.users.domain.model.Role;
import com.pragma.users.manager.ManagerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RoleHandlerTest {
    private RoleHandler roleHandler;

    @Mock
    private IRoleServicePort roleServicePort;

    @Mock
    private RoleMapper roleMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        roleHandler = new RoleHandler(roleServicePort, roleMapper);
    }

    @Test
     void getRoleById_existingRole_shouldReturnRoleDto() {
        // Arrange
        int roleId = 123;
        Role role = ManagerFactory.createRole();
        RoleDto roleDto = new RoleDto();
        when(roleServicePort.getRoleById(roleId)).thenReturn(role);
        when(roleMapper.roleToRoleDto(role)).thenReturn(roleDto);

        // Act
        RoleDto result = roleHandler.getRoleById(roleId);

        // Assert
        assertEquals(roleDto, result);
    }

    @Test
    void getRoleById_nonExistingRole_shouldReturnNull() {
        // Arrange
        int roleId = 123;
        when(roleServicePort.getRoleById(roleId)).thenReturn(null);

        // Act
        RoleDto result = roleHandler.getRoleById(roleId);

        // Assert
        assertNull(result);
    }

    @Test
    void getRoleByName_existingRole_shouldReturnRoleDto() {
        // Arrange
        String roleName = "Admin";
        Role role = ManagerFactory.createRole();
        RoleDto roleDto = new RoleDto();
        when(roleServicePort.getRoleByName(roleName)).thenReturn(role);
        when(roleMapper.roleToRoleDto(role)).thenReturn(roleDto);

        // Act
        RoleDto result = roleHandler.getRoleByName(roleName);

        // Assert
        assertEquals(roleDto, 3);
    }

    @Test
     void getRoleByName_nonExistingRole_shouldReturnNull() {
        // Arrange
        String roleName = "NonExistingRole";
        when(roleServicePort.getRoleByName(roleName)).thenReturn(null);

        // Act
        RoleDto result = roleHandler.getRoleByName(roleName);

        // Assert
        assertNull(result);
    }

}