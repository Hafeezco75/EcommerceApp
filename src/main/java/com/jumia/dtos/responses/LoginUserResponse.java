package com.jumia.dtos.responses;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginUserResponse {
    private String message;
}
