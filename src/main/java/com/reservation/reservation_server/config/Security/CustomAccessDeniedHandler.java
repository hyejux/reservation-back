package com.reservation.reservation_server.config.Security;


import java.io.IOException;
import java.time.LocalDateTime;

import com.reservation.reservation_server.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;



import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "FORBIDDEN_EXCEPTION_HANDLER")
@AllArgsConstructor
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    private final ObjectMapper objectMapper;

    @Override
    public void handle(final HttpServletRequest request, final HttpServletResponse response,
                       final AccessDeniedException accessDeniedException) throws IOException, ServletException {
        log.error("No Authorities", accessDeniedException);

        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                HttpStatus.FORBIDDEN.value(),
                accessDeniedException.getMessage(),
                LocalDateTime.now()
        );

        String responseBody = objectMapper.writeValueAsString(errorResponseDto);

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.FORBIDDEN.value());  // 403 Forbidden 상태 코드 설정
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseBody);
    }
}