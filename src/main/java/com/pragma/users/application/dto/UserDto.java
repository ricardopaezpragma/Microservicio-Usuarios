package com.pragma.users.application.dto;

import lombok.Data;

import java.time.LocalDate;

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
