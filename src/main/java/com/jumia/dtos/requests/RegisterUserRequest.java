package com.jumia.dtos.requests;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RegisterUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;

}
