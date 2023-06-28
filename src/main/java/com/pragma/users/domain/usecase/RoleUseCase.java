package com.pragma.users.domain.usecase;

import com.pragma.users.domain.api.IRoleServicePort;
import com.pragma.users.domain.model.Role;
import com.pragma.users.domain.spi.IRolePersistencePort;

public class RoleUseCase implements IRoleServicePort {
    private final IRolePersistencePort rolPersistencePort;

    public RoleUseCase(IRolePersistencePort rolPersistencePort) {
        this.rolPersistencePort = rolPersistencePort;
    }

    @Override
    public Role getRoleById(int id) {
        return rolPersistencePort.getRoleById(id);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return rolPersistencePort.getRoleByName(roleName);
    }
}
