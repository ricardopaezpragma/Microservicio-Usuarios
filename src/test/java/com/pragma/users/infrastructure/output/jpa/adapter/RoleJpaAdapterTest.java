package com.pragma.users.infrastructure.output.jpa.adapter;

import com.pragma.users.domain.model.Role;
import com.pragma.users.infrastructure.output.jpa.entity.RoleEntity;
import com.pragma.users.infrastructure.output.jpa.mapper.RoleEntityMapper;
import com.pragma.users.infrastructure.output.jpa.repository.RoleRepository;
import com.pragma.users.manager.ManagerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RoleJpaAdapterTest {
    private RoleJpaAdapter roleJpaAdapter;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private RoleEntityMapper roleEntityMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        roleJpaAdapter = new RoleJpaAdapter(roleRepository, roleEntityMapper);
    }

    @Test
    void getRoleById_existingRole_shouldReturnMappedRole() {
        // Arrange
        int roleId = 1;
        RoleEntity roleEntity = new RoleEntity();
        Role role = ManagerFactory.createRole();
        when(roleRepository.findById(roleId)).thenReturn(Optional.of(roleEntity));
        when(roleEntityMapper.toRole(roleEntity)).thenReturn(role);

        // Act
        Role result = roleJpaAdapter.getRoleById(roleId);

        // Assert
        assertEquals(role, result);
    }

    @Test
    void getRoleById_nonExistingRole_shouldThrowRuntimeException() {
        // Arrange
        int roleId = 1;
        when(roleRepository.findById(roleId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(RuntimeException.class, () -> roleJpaAdapter.getRoleById(roleId));
    }

    @Test
    void getRoleByName_existingRole_shouldReturnMappedRole() {
        // Arrange
        String roleName = "admin";
        RoleEntity roleEntity = new RoleEntity();
        Role role = ManagerFactory.createRole();
        when(roleRepository.findOneByName(roleName)).thenReturn(Optional.of(roleEntity));
        when(roleEntityMapper.toRole(roleEntity)).thenReturn(role);

        // Act
        Role result = roleJpaAdapter.getRoleByName(roleName);

        // Assert
        assertEquals(role, result);
    }

    @Test
    void getRoleByName_nonExistingRole_shouldThrowRuntimeException() {
        // Arrange
        String roleName = "non_existing_role";
        when(roleRepository.findOneByName(roleName)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(RuntimeException.class, () -> roleJpaAdapter.getRoleByName(roleName));
    }

}