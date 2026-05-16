package com.bookingcar.utilities;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;


import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.List;

@Component
public class JwtUtil {

    // Khóa bí mật (Cần dài tối thiểu 32 ký tự)
    private final String SECRET_KEY = "BookingCarSystem_SecretKey_MustBeLongEnough";

    // Tách riêng thời gian: Access Token , Refresh Token
    private final long ACCESS_EXPIRATION_TIME = 1800000; // 30 * 60 * 1000
    private final long REFRESH_EXPIRATION_TIME = 604800000; // 7 * 24 * 60 * 60 * 1000

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    // Access token chứa role
    public String generateToken(String username, String role) {
        return Jwts.builder()
                .setSubject(username)
                .claim("role", "ROLE_" + role.toUpperCase())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + ACCESS_EXPIRATION_TIME))
                .signWith(getSigningKey())
                .compact();
    }

    // Refresh token
    public String generateRefreshToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + REFRESH_EXPIRATION_TIME))
                .signWith(getSigningKey())
                .compact();
    }

    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    // Trích role từ access toke
    public List<GrantedAuthority> extractAuthorities(String token) {
        String role = getClaims(token).get("role", String.class);
        return List.of(new SimpleGrantedAuthority(role));
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean validateToken(String token) {
        try {
            return !getClaims(token).isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

}
