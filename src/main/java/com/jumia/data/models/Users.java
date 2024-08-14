package com.jumia.data.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Users {
    private String id;
    private String name;
    private String phoneNumber;
    private String email;
    private String password;
    private RoleType role;

}
