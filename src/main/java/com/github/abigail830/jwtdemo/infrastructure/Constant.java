package com.github.abigail830.jwtdemo.infrastructure;

public class Constant {

    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer";
    public static final long EXPIRATION_TIME = 864_000_000; //10 days

    public static final String SIGN_UP_URL = "/users/login";
    public static final String REGISTER_URL = "/users/register";
}
