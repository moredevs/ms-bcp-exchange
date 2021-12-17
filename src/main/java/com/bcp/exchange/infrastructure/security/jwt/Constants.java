package com.bcp.exchange.infrastructure.security.jwt;

public class Constants {


	public static final String LOGIN_URL = "/login";
	public static final String HEADER_AUTHORIZATION_KEY = "Authorization";
	public static final String TOKEN_BEARER_PREFIX = "Bearer ";
	public static final String HEADER_ROLES =  "Roles";
	public static final String ISSUER_INFO = "https://www.bco.com.pe/";
	public static final String SUPER_SECRET_KEY = "1234";
	public static final long TOKEN_EXPIRATION_TIME = 18_000;

}
