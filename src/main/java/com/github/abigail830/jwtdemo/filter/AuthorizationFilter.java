package com.github.abigail830.jwtdemo.filter;

import com.github.abigail830.jwtdemo.infrastructure.JWTAuth0Util;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import java.io.IOException;

//@Component
//@Order(1)
//@WebFilter(filterName = "AuthorizationFilter", urlPatterns = "/*")
public class AuthorizationFilter implements Filter {

    @Autowired
    JWTAuth0Util jwtAuth0Util;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

//        ContentCachingRequestWrapper requestWrapper =
//                new ContentCachingRequestWrapper((HttpServletRequest) servletRequest);
//
//        if(requestWrapper ==null){
//            filterChain.doFilter(servletRequest, servletResponse);
//        }else{
//            HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
//
//            if (requestWrapper.getHeader(HEADER_AUTHORIZATION) == null) {
//                ApplicationUser applicationUser = new ObjectMapper()
//                        .readValue(requestWrapper.getInputStream(), ApplicationUser.class);
//                //here should access redis/db to verify user info
//                //if success then sign as token
//                final String token = jwtAuth0Util.sign(applicationUser);
//                httpServletResponse.setHeader(HEADER_AUTHORIZATION, token);
//            }
//            filterChain.doFilter(requestWrapper, httpServletResponse);
//        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
