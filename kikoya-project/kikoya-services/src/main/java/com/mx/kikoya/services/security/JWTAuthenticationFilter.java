package com.mx.kikoya.services.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;

	private String ISSUER_INFO = "the_boss_ricks";

	private Long TOKEN_EXPIRATION_TIME = 3600000L;

	private String HEADER_AUTHORIZACION_KEY = "Authorization";

	private String TOKEN_BEARER_PREFIX = "Bearer";

	private String SUPER_SECRET_KEY = "r!!!cks_t3st_k1k0y0";

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		try {

			CustomUserDetails credenciales = new ObjectMapper().readValue(request.getInputStream(),
					CustomUserDetails.class);

			return authenticationManager.authenticate(new CustomAuthentication(credenciales.getUsername(),
					credenciales.getPassword(), credenciales.getToken()));

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication auth) throws IOException, ServletException {

		try {

			String token = Jwts.builder().setIssuedAt(new Date()).setIssuer(ISSUER_INFO)
					.setSubject(((CustomUserDetails) auth.getPrincipal()).getId().toString())
					.setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME))
					.signWith(SignatureAlgorithm.HS512, SUPER_SECRET_KEY).compact();

			response.addHeader(HEADER_AUTHORIZACION_KEY, TOKEN_BEARER_PREFIX + " " + token);

			response.addHeader("Access-Control-Expose-Headers", "*");
		} catch (Exception e) {

			throw new BadCredentialsException("Sin Token");

		}

	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {

		Utils.sendMessageJSON(response, failed.getMessage(), 403, "ko");

	}
}