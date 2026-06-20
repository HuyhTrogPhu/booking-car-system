package com.bookingcar.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class LoginRequest {

    private String username;
    private String password;
    private String email;
    private String accessToken;
    private String refreshToken;
}
