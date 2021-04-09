package com.spring.security.example.common.security;


import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler{

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
	    Authentication authentication) throws IOException, ServletException {
	List<String> authorities = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
	String location = null;
	if(authorities.contains("ROLE_USER")) {
	    location = "/main";
	}
	if(authorities.contains("ROLE_ADMIN")) {
	    location = "/admin";
	}
	
	response.sendRedirect(location);

    }

}
