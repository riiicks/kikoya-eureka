package com.mx.kikoya.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private CustomDetailsService userDetailsService;

	@Autowired
	PasswordEncoder bCryptPasswordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		CustomAuthentication bean = (CustomAuthentication) authentication;

		CustomUserDetails userDetail = userDetailsService.loadUserByUsernames(bean.getName());

		if (userDetail != null
				&& bCryptPasswordEncoder.matches(bean.getCredentials().toString(), userDetail.getPassword())) {

			Authentication auth = new CustomAuthentication(userDetail, userDetail.getPassword(),
					userDetail.getAuthorities());

			return auth;

		}

		throw new BadCredentialsException("Credenciales Invalidas");
	}

	@Override
	public boolean supports(Class<?> authentication) {

		return authentication.equals(CustomAuthentication.class);

	}

}
