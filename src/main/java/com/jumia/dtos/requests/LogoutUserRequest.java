package com.jumia.dtos.requests;

import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class LogoutUserRequest {
    private String message;
    private boolean isLoggedIn;

}
