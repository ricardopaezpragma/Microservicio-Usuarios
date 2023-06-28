package com.pragma.users.domain.spi;

import com.pragma.users.domain.model.Role;

public interface IRolePersistencePort {
    Role getRoleById(int id);
    Role getRoleByName(String roleName);

}
