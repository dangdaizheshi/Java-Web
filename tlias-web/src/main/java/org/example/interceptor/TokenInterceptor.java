package org.example.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.utils.JwtUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getRequestURI(); // /tlias/login

        if (path.contains("login") || path.contains("css") || path.contains("js") || path.contains("fonts")) {
            // 放行
            return true;
        } else {
            // 获取请求头中的token
            String token = request.getHeader("token");
            if (token == null || token.isEmpty()) {
                response.setStatus(401);
                return false;
            }
            //校验 token
            try {
                JwtUtils.parseJwt(token);
            } catch (Exception e) {
                response.setStatus(401);
                return false;
            }

            // 放行
            return true;
        }
    }
}
