package com.bookingcar.identityservice.controller;

import com.bookingcar.dto.request.LoginRequest;
import com.bookingcar.dto.response.ApiResponse;
import com.bookingcar.dto.response.TokenResponse;
import com.bookingcar.exception.AppException;
import com.bookingcar.exception.ErrorCode;
import com.bookingcar.identityservice.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking-car-system/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<TokenResponse>> login(@RequestBody LoginRequest loginRequest) {

        TokenResponse result = authenticationService.login(loginRequest);

        ResponseCookie refreshToken = createHttpOnlyCookie("refreshToken", result.getRefreshToken(), 7 * 24 * 60 * 60);
        ResponseCookie accessToken = createHttpOnlyCookie("accessToken", result.getAccessToken(), 30 * 60 * 1000);

        // Ẩn refresh token trong JSON body để tăng tính bảo mật (Frontend chỉ cần Access Token)
        // result.setRefreshToken(null);

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, refreshToken.toString())
                .header(HttpHeaders.SET_COOKIE, accessToken.toString())
                .body(ApiResponse.<TokenResponse>builder().result(result).build());
    }

    // Đọc cookie và cấp Access token mới
    @PostMapping("/refresh")
    public ResponseEntity<ApiResponse<TokenResponse>> refresh(@CookieValue(name = "refreshToken", required = false) String refreshToken) {

        if (refreshToken == null) {
            throw new AppException(ErrorCode.MISSING_COOKIE);
        }

        TokenResponse result = authenticationService.resetRefreshToken(refreshToken);
        result.setRefreshToken(null);

        return ResponseEntity.ok().body(ApiResponse.<TokenResponse>builder().result(result).build());
    }

    // Ép trình duyệt xóa cookie
    @PostMapping("/logout")
    public ResponseEntity<ApiResponse<String>> logout() {

        ResponseCookie deleteCookie = createHttpOnlyCookie("refreshToken", "", 0);
        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, deleteCookie.toString())
                .body(ApiResponse.<String>builder().result("Logout success").build());
    }

    // Hàm tiện ích tạo HttpOnly Cookie
    private ResponseCookie createHttpOnlyCookie(String name, String value, long maxAgeInSeconds) {
        return ResponseCookie.from(name, value)
                .httpOnly(true)                // Bảo mật: JS không đọc được
                .secure(false)                // Đổi thành true nếu dùng HTTPS (Production)
                .path("/")                    // Có hiệu lực cho toàn bộ domain
                .maxAge(maxAgeInSeconds)      // Thời gian sống
                .sameSite("Strict")           // Chống tấn công CSRF
                .build();
    }
}
