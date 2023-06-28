package com.pragma.users.infrastructure.output.jpa.adapter;

import com.pragma.users.domain.model.Role;
import com.pragma.users.domain.spi.IRolePersistencePort;
import com.pragma.users.infrastructure.output.jpa.mapper.RoleEntityMapper;
import com.pragma.users.infrastructure.output.jpa.repository.RoleRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RoleJpaAdapter implements IRolePersistencePort {
    private final RoleRepository roleRepository;
    private final RoleEntityMapper roleEntityMapper;

    @Override
    public Role getRoleById(int id) {
        return roleEntityMapper.toRole(roleRepository.findById(id).orElseThrow(() -> new RuntimeException()));
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleEntityMapper.toRole(roleRepository.findOneByName(roleName).orElseThrow(()->new RuntimeException()));
    }
}
