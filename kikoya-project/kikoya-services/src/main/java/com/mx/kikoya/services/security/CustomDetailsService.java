package com.mx.kikoya.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mx.kikoya.services.dao.UsuarioDAO;
import com.mx.kikoya.services.dto.UsuarioDTO;

@Service
public class CustomDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioDAO usuarioDAO;

	public CustomUserDetails loadUserByUsernames(String username) throws UsernameNotFoundException {

		UsuarioDTO usuario = usuarioDAO.getUsuarioByUsernameSession(username);

		if (usuario == null)
			throw new UsernameNotFoundException("Usuario invalido");

		return getBean(usuario);

	}

	public CustomUserDetails loadUserById(Long id) throws UsernameNotFoundException {

		UsuarioDTO usuario = usuarioDAO.getByIdSession(id);

		if (usuario == null)
			throw new UsernameNotFoundException("Usuario invalido");

		return getBean(usuario);

	}

	private CustomUserDetails getBean(UsuarioDTO dto) {

		CustomUserDetails bean = new CustomUserDetails();

		bean.setUsername(dto.getUsername());

		bean.setPassword(dto.getPwd());

		bean.setEnabled(dto.getEstatus() == 1);

		bean.setId(dto.getUsuarioId());

		return bean;

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
