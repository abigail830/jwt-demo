package com.github.abigail830.jwtdemo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static com.github.abigail830.jwtdemo.infrastructure.Constant.REGISTER_URL;
import static com.github.abigail830.jwtdemo.infrastructure.Constant.SIGN_UP_URL;

@Configuration

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin")
                .password(bCryptPasswordEncoder.encode("admin"))
                .roles("ADMIN")
                .and()
                .withUser("user")
                .password(bCryptPasswordEncoder.encode("password"))
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().
                and().csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/swagger-ui.html",
                        "/swagger-resources/**",
                        "/webjars/**",
                        "/configuration/security",
                        "/configuration/ui",
                        "/v2/api-docs",
                        "/hello").permitAll()
                .antMatchers(HttpMethod.POST, SIGN_UP_URL, REGISTER_URL).permitAll()
//                .antMatchers("/admins").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and().formLogin();
    }
}
