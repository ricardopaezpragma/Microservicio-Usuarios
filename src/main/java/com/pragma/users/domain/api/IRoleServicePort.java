package com.pragma.users.domain.api;

import com.pragma.users.domain.model.Role;

public interface IRoleServicePort {
    Role getRoleById(int id);
    Role getRoleByName(String roleName);

}
