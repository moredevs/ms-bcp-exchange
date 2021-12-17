package com.bcp.exchange.infrastructure.security.jwt;

import com.bcp.exchange.application.ports.in.LoggingRegister;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import static com.bcp.exchange.infrastructure.security.jwt.Constants.*;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

	public JWTAuthorizationFilter(AuthenticationManager authManager) {
		super(authManager);
	}

	private LoggingRegister loggingRegister;

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		if(loggingRegister==null){
			ServletContext servletContext = req.getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
			loggingRegister = webApplicationContext.getBean(LoggingRegister.class);
		}
		String header = req.getHeader(HEADER_AUTHORIZATION_KEY);
		if (header == null || !header.startsWith(TOKEN_BEARER_PREFIX)) {
			chain.doFilter(req, res);
			return;
		}
		UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(req, res);
	}

	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request)  {
		String token = getToken(request);

		if (token != null) {
			String user = Jwts.parser()
						.setSigningKey(SUPER_SECRET_KEY)
						.parseClaimsJws(token.replace(TOKEN_BEARER_PREFIX, ""))
						.getBody()
						.getSubject();
			if (user != null) {
				loggingRegister.registerLogFromRequest(user,request);
				return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
			}else{
				loggingRegister.registerLogFromRequest("NO REGISTER 401",request);
			}
			return null;
		}
		return null;
	}

	private String getToken(HttpServletRequest request){

		String header = request.getHeader(HEADER_AUTHORIZATION_KEY);
		if(header != null && header.startsWith("Bearer"))
			return header.replace(TOKEN_BEARER_PREFIX, "");
		return null;

	}
}
