package com.bookingcar.identityservice.service;

import com.bookingcar.dto.request.LoginRequest;
import com.bookingcar.dto.response.TokenResponse;
import com.bookingcar.exception.AppException;
import com.bookingcar.exception.ErrorCode;
import com.bookingcar.identityservice.entity.User;
import com.bookingcar.identityservice.repository.UserRepository;
import com.bookingcar.utilities.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public TokenResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        User user = userRepository.findByUsernameOrEmail(loginRequest.getUsername(), loginRequest.getEmail())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        String accessToken = jwtUtil.generateToken(user.getUsername(), user.getRole().getRole());
        String refreshToken = jwtUtil.generateRefreshToken(user.getUsername());

        return TokenResponse.builder().accessToken(accessToken).refreshToken(refreshToken).build();
    }


    public TokenResponse resetRefreshToken(String refreshToken) {
        String username;
        try {
            username = jwtUtil.extractUsername(refreshToken);
        } catch (Exception e) {
            // Nếu token hỏng hoặc hết hạn, trả về lỗi END_TOKEN luôn
            throw new AppException(ErrorCode.END_TOKEN);
        }

        // 2. Kiểm tra tính hợp lệ và hạn dùng
        if (!jwtUtil.validateToken(refreshToken, username)) {
            throw new AppException(ErrorCode.END_TOKEN);
        }

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        // 4. Tạo Access Token mới (giữ nguyên logic lấy role từ thực thể User của bạn)
        String newAccessToken = jwtUtil.generateToken(user.getUsername(), user.getRole().getRole());

        // 5. Trả về cặp Token mới cho Controller đưa vào Cookie/Body
        return TokenResponse.builder()
                .accessToken(newAccessToken)
                .refreshToken(refreshToken)
                .build();
    }
}
