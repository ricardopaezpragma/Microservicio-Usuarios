package com.pragma.users.application.handler;

import com.pragma.users.application.dto.RoleDto;
import com.pragma.users.application.mapper.RoleMapper;
import com.pragma.users.domain.api.IRoleServicePort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleHandler implements IRoleHandler{
    private final IRoleServicePort roleServicePort;
    private final RoleMapper roleMapper;
    @Override
    public RoleDto getRoleById(int roleId) {
        return roleMapper.roleToRoleDto(roleServicePort.getRoleById(roleId));
    }

    @Override
    public RoleDto getRoleByName(String roleName) {
        return roleMapper.roleToRoleDto(roleServicePort.getRoleByName(roleName));
    }
}
