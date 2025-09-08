package com.reservation.reservation_server.config.Security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reservation.reservation_server.exception.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {

        // 인증 실패 시 응답 내용 설정
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");

        // JSON 형태로 에러 메시지 반환 (필요에 따라 커스텀 클래스 사용 가능)
        String json = objectMapper.writeValueAsString(
                new ErrorResponse("Unauthorized", authException.getMessage())
        );

        response.getWriter().write(json);
    }

}
