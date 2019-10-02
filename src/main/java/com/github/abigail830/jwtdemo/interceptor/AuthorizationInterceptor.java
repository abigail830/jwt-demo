package com.github.abigail830.jwtdemo.interceptor;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.github.abigail830.jwtdemo.infrastructure.JWTAuth0Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

import static com.github.abigail830.jwtdemo.infrastructure.Constant.HEADER_AUTHORIZATION;

@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

    @Autowired
    JWTAuth0Util jwtAuth0Util;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {

        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        if (method.isAnnotationPresent(IgnoreToken.class)) {
            return true;
        } else {
            String token = request.getHeader(HEADER_AUTHORIZATION);
            if (token == null) {
                response.getWriter().write("No Token, please login first.");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return false;
            } else {
                try {
                    jwtAuth0Util.verify(token);
                } catch (JWTVerificationException exception) {
                    response.getWriter().write("Fail to verify token.");
                    response.setContentType("application/json");
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    return false;
                }
                return true;
            }
        }
    }

}
