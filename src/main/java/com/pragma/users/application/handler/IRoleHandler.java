package com.pragma.users.application.handler;

import com.pragma.users.application.dto.RoleDto;

public interface IRoleHandler {
    RoleDto getRoleById(int roleId);
    RoleDto getRoleByName(String roleName);
}
