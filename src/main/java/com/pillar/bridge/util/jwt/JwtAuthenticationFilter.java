package com.pillar.bridge.util.jwt;

import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // 토큰이 필요 없는 URL
        List<String> skipUrls = Arrays.asList("/device/register", "/places/recommendations", "/device/refresh");
        String requestURL = request.getRequestURI();
        if (skipUrls.stream().anyMatch(url -> requestURL.contains(url))) {
            filterChain.doFilter(request, response);
            return;
        }

        try {
            String token = tokenFromRequest(request);
            if (StringUtils.hasText(token) && jwtUtil.validateToken(token)) {
                String uuid = jwtUtil.getUuidFromToken(token);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(uuid, null, null);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                throw new JwtException("토큰이 누락되었습니다.");
            }
            filterChain.doFilter(request, response);
        } catch (JwtException e) {
            throw e;
        }
    }


    // 헤더에서 토큰 추출
    private String tokenFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}

