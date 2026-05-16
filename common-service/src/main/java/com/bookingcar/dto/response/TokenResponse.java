package com.bookingcar.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class TokenResponse {

    String username;
    String password;
    String accessToken;
    String refreshToken;

    public TokenResponse(String accessToken, String refreshTokenString) {
        this.accessToken = accessToken;
        this.refreshToken = refreshTokenString;
    }
}
