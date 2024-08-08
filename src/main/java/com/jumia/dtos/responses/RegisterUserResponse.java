package com.jumia.dtos.responses;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class RegisterUserResponse {
    private String message;
}
