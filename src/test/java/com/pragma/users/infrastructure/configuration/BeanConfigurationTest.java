package com.pragma.users.infrastructure.configuration;

import com.pragma.users.domain.api.IRoleServicePort;
import com.pragma.users.domain.api.IUserServicePort;
import com.pragma.users.domain.spi.IRolePersistencePort;
import com.pragma.users.domain.spi.IUserPersistencePort;
import com.pragma.users.domain.usecase.RoleUseCase;
import com.pragma.users.domain.usecase.UserUseCase;
import com.pragma.users.infrastructure.output.jpa.adapter.RoleJpaAdapter;
import com.pragma.users.infrastructure.output.jpa.adapter.UserJpaAdapter;
import com.pragma.users.infrastructure.output.jpa.mapper.RoleEntityMapper;
import com.pragma.users.infrastructure.output.jpa.mapper.UserEntityMapper;
import com.pragma.users.infrastructure.output.jpa.repository.RoleRepository;
import com.pragma.users.infrastructure.output.jpa.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

 class BeanConfigurationTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserEntityMapper userEntityMapper;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private RoleEntityMapper roleEntityMapper;

    private BeanConfiguration beanConfiguration;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        beanConfiguration = new BeanConfiguration(userRepository, userEntityMapper, roleRepository, roleEntityMapper);
    }

    @Test
    void userServicePort_shouldReturnUserUseCase() {
        // Arrange

        // Act
        IUserServicePort userServicePort = beanConfiguration.userServicePort();

        // Assert
        assertNotNull(userServicePort);
        assertTrue(userServicePort instanceof UserUseCase);
    }

    @Test
    void userPersistencePort_shouldReturnUserJpaAdapter() {
        // Arrange

        // Act
        IUserPersistencePort userPersistencePort = beanConfiguration.userPersistencePort();

        // Assert
        assertNotNull(userPersistencePort);
        assertTrue(userPersistencePort instanceof UserJpaAdapter);
        UserJpaAdapter userJpaAdapter = (UserJpaAdapter) userPersistencePort;
    }

    @Test
    void roleServicePort_shouldReturnRoleUseCase() {
        // Arrange

        // Act
        IRoleServicePort roleServicePort = beanConfiguration.roleServicePort();

        // Assert
        assertNotNull(roleServicePort);
        assertTrue(roleServicePort instanceof RoleUseCase);
    }

    @Test
    void rolePersistencePort_shouldReturnRoleJpaAdapter() {
        // Arrange

        // Act
        IRolePersistencePort rolePersistencePort = beanConfiguration.rolePersistencePort();

        // Assert
        assertNotNull(rolePersistencePort);
        assertTrue(rolePersistencePort instanceof RoleJpaAdapter);
    }
}
