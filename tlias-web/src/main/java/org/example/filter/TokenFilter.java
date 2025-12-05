package org.example.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.utils.JwtUtils;

import java.io.IOException;

//@WebFilter(urlPatterns = "/*") // 拦截所有请求
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 获取请求路径
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String path = request.getRequestURI(); // /tlias/login

        if (path.contains("login") || path.contains("css") || path.contains("js") || path.contains("fonts")) {
            // 放行
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            // 获取请求头中的token
            String token = request.getHeader("token");
            if (token == null || token.isEmpty()) {
                response.setStatus(401);
                return;
            }
            //校验 token
            try {
                JwtUtils.parseJwt(token);
            } catch (Exception e) {
                response.setStatus(401);
                return;
            }

            // 放行
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
