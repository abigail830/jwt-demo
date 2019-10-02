package com.github.abigail830.jwtdemo.interceptor;

import com.auth0.jwt.exceptions.JWTCreationException;
import com.github.abigail830.jwtdemo.infrastructure.JWTAuth0Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

import static com.github.abigail830.jwtdemo.infrastructure.Constant.HEADER_AUTHORIZATION;
import static com.github.abigail830.jwtdemo.infrastructure.Constant.HEADER_USERNAME;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

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

        if (method.isAnnotationPresent(UserLoginToken.class)) {
            final String usename = request.getHeader(HEADER_USERNAME);
            if (usename != null) {
                try {
                    String token = jwtAuth0Util.sign(usename);
                    response.setHeader(HEADER_AUTHORIZATION, token);
                } catch (JWTCreationException ex) {
                    return failToSignTokenResponse(response);
                }
            } else {
                return failToSignTokenResponse(response);
            }

        }
        return true;
    }

    private boolean failToSignTokenResponse(HttpServletResponse response) throws IOException {
        response.getWriter().write("Fail to sign token.");
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return false;
    }

}
