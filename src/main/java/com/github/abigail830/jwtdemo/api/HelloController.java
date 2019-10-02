package com.github.abigail830.jwtdemo.api;

import com.github.abigail830.jwtdemo.application.UserApplService;
import com.github.abigail830.jwtdemo.interceptor.IgnoreToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @Autowired
    UserApplService userApplService;

    @GetMapping
    @IgnoreToken
    public String hello() {
        return "Hello World";
    }
}
