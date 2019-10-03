package com.github.abigail830.jwtdemo.interceptor;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "httpServletRequestWrapperFilter", urlPatterns = {"/*"})
public class HttpServletRequestWrapperFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        ServletRequest requestWrapper = null;
        if (servletRequest instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

            // 遇到post方法才对request进行包装
            String methodType = httpRequest.getMethod();
            // 上传文件时同样不进行包装
            String servletPath = httpRequest.getRequestURI().toString();
            if ("POST".equals(methodType)) {
                requestWrapper = new BodyReaderHttpServletRequestWrapper(
                        (HttpServletRequest) servletRequest);
            }
        }

        if (null == requestWrapper) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(requestWrapper, servletResponse);
        }
    }
}
