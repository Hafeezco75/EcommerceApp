package com.jumia.dtos.requests;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class LoginUserRequest {
    private String email;
    private String password;
}
