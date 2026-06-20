package com.bookingcar.config;

import com.bookingcar.utilities.JwtUtil;
import jakarta.annotation.Nonnull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, @Nonnull HttpServletResponse response, @Nonnull FilterChain filterChain) throws ServletException, IOException {

        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            // Nếu không có token, cho đi tiếp luôn (SecurityConfig sẽ quyết định xem api đó có cần quyền không)
            filterChain.doFilter(request, response);
            return;
        }

        String token = header.substring(7);

        // 1. BẮT BUỘC PHẢI CÓ TRY-CATCH Ở ĐÂY ĐỂ BẮT LỖI TOKEN HẾT HẠN/SAI CHỮ KÝ
        try {
            String username = jwtUtil.extractUsername(token);

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

                // 2. Kiểm tra Token có hợp lệ và khớp với username không (Truyền đủ 2 tham số theo JwtUtil của bạn)
                if (jwtUtil.validateToken(token, username)) {

                    // 3. Lấy Quyền (Role) trực tiếp từ Token bằng hàm bạn đã viết sẵn
                    List<GrantedAuthority> authorities = jwtUtil.extractAuthorities(token);

                    // 4. Tạo đối tượng Authentication
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            username,
                            null,
                            authorities
                    );
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    // 5. QUAN TRỌNG: Phải nạp authToken vào Context để kích hoạt quyền hạn!
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }
        } catch (Exception e) {
            // Nếu token lỗi hoặc hết hạn, ta chỉ ghi log log chứ KHÔNG ném lỗi ra ngoài.
            // Request lỗi token khi vào API permitAll() vẫn sẽ chạy bình thường.
            logger.error("Xác thực JWT thất bại: " + e.getMessage());
        }

        // QUAN TRỌNG: Lệnh này bắt buộc phải nằm ngoài cùng của hàm để kết thúc chu trình Filter
        filterChain.doFilter(request, response);
    }
}
