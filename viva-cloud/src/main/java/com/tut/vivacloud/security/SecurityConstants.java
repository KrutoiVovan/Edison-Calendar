package com.tut.vivacloud.security;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "garland.security")
@Data
public class SecurityConstants {

    public static String authLoginUrl = "/api/authenticate";

    public static String JWT_SECRET = "n2r5u8x/A%D*G-KaPdSgVkYp3s6v9y$B&E(H+MbQeThWmZq4t7w!z%C*F-J@NcRf";

    public static String TOKEN_HEADER = "Authorization";
    public static String TOKEN_PREFIX = "Bearer ";
    public static String TOKEN_TYPE = "JWT";
    public static String TOKEN_ISSUER = "secure-api";
    public static String TOKEN_AUDIENCE = "secure-app";
}