package com.pragma.users.application.dto;

import com.pragma.users.domain.model.Role;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UserDto {
    private Integer id;
    private String name;
    private String lastName;
    private String documentId;
    private String cellPhone;
    private LocalDate dateBirth;
    private String email;
    private String password;
    private String role;
}
