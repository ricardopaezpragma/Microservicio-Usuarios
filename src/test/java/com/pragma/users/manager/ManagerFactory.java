package com.pragma.users.manager;


import com.pragma.users.domain.model.Role;
import com.pragma.users.domain.model.User;
import com.pragma.users.infrastructure.output.jpa.entity.UserEntity;

import java.time.LocalDate;

public class ManagerFactory {

    public static User createUser() {
        return new User(1, "John", "Doe", "11234", "31203948", LocalDate.of(1955, 01, 01), "email@emal.com", "password", 1);
    }
    public static UserEntity createUserEntity(){
        return new UserEntity(1, "John", "Doe", "11234", "31203948", LocalDate.of(1955, 01, 01), "email@emal.com", "password", 1);
    }
    public static Role createRole(){
        return new Role(1,"ADMIN","ADMINISTRADOR");
    }
}
