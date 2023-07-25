package com.pragma.users.domain.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class User {
    private Integer id;
    private String name;
    private String lastName;
    private String documentId;
    private String cellPhone;
    private LocalDate dateBirth;
    private String email;
    private String password;
    private Integer roleId;
}
