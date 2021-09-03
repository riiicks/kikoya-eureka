package com.mx.kikoya.services.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth.getPrincipal() instanceof CustomUserDetails)
			Utils.sendMessageJSON(response, "Sin Permiso", 407, "ko");

		if (auth.getPrincipal() instanceof AnonymousAuthenticationToken)
			Utils.sendMessageJSON(response, "Sin Sesion", 408, "ko");

		Utils.sendMessageJSON(response, accessDeniedException.getMessage(), 409, "ko");

	}

}
