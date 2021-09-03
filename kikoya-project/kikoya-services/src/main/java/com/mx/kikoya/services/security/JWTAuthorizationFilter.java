package com.mx.kikoya.services.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

	private String HEADER_AUTHORIZACION_KEY = "Authorization";

	private String TOKEN_BEARER_PREFIX = "Bearer";

	private String SUPER_SECRET_KEY = "r!!!cks_t3st_k1k0y0";

	private CustomDetailsService userDetailsService;

	public JWTAuthorizationFilter(AuthenticationManager authManager) {
		super(authManager);
	}

	public JWTAuthorizationFilter(AuthenticationManager authManager, UserDetailsService userDetailsService) {

		super(authManager);

		this.userDetailsService = (CustomDetailsService) userDetailsService;

	}

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		String header = req.getHeader(HEADER_AUTHORIZACION_KEY);

		if (header == null || !header.startsWith(TOKEN_BEARER_PREFIX)) {

			chain.doFilter(req, res);

			return;

		}

		UsernamePasswordAuthenticationToken authentication = getAuthentication(req, res);

		SecurityContextHolder.getContext().setAuthentication(authentication);

		chain.doFilter(req, res);

	}

	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request, HttpServletResponse res)
			throws IOException {

		String token = request.getHeader(HEADER_AUTHORIZACION_KEY);

		if (token != null) {

			try {

				Jws<Claims> claims = Jwts.parser().setSigningKey(SUPER_SECRET_KEY)
						.parseClaimsJws(token.replace(TOKEN_BEARER_PREFIX, ""));

				String user = claims.getBody().getSubject();

				CustomUserDetails bean = userDetailsService.loadUserById(new Long(user));

				if (user != null)
					return new UsernamePasswordAuthenticationToken(bean, bean.getPassword(), bean.getAuthorities());

				Utils.sendMessageJSON(res, "Credenciales Invalidas", 404, "ko");

			} catch (ExpiredJwtException e) {

				Utils.sendMessageJSON(res, "Sesion Expirada", 405, "ko");

			} catch (SignatureException e) {

				Utils.sendMessageJSON(res, "Token Invalido", 406, "ko");

			}

		}

		return null;

	}
}