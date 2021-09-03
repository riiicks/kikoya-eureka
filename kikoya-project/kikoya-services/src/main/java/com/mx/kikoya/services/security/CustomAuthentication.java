package com.mx.kikoya.services.security;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class CustomAuthentication extends UsernamePasswordAuthenticationToken {

	private static final long serialVersionUID = -7820370225478769310L;

	private String token;

	public CustomAuthentication(Object principal, Object credentials, String token) {

		super(principal, credentials);

		this.token = token;
		
	}

	public CustomAuthentication(Object principal, Object credentials,
			Collection<? extends GrantedAuthority> authorities) {

		super(principal, credentials, authorities);

	}

	public String getToken() {
		return token;
	}

}
