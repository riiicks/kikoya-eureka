package com.mx.kikoya.services.dao;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.mx.kikoya.services.dto.UsuarioDTO;

@Repository
public class UsuarioDAO extends GenericDAO {

	public UsuarioDTO getUsuarioByUsernameSession(String username) {

		final String query = "SELECT username, pwd, estatus, usuario_id FROM usuario WHERE username LIKE ?;";

		try {

			List<UsuarioDTO> lst = template.query(query, new Object[] { username },
					new BeanPropertyRowMapper<UsuarioDTO>(UsuarioDTO.class));

			return lst.size() > 0 ? lst.get(0) : null;

		} catch (Exception e) {
			log.error("Ocurrio un error al obtener el getUsuarioByUsernameSession: ", e);
			return null;
		}
	}

	public UsuarioDTO getByIdSession(Long id) {

		try {

			final String query = "SELECT username, pwd, estatus, usuario_id FROM usuario WHERE usuario_id = ? and estatus = 1;";

			return template.queryForObject(query, new Object[] { id },
					new BeanPropertyRowMapper<UsuarioDTO>(UsuarioDTO.class));

		} catch (EmptyResultDataAccessException e) {
			log.error("Ocurrio un error al obtener el getByIdSession: ", e);
			return null;
		}
	}

	public Integer saveUsuario(UsuarioDTO dto) {

		try {

			final String sql = "INSERT INTO public.usuario (nombre, username, pwd, usuario_alta, email) VALUES( ?, ?, ?, ?, ?) RETURNING usuario_id;";

			return template.queryForObject(sql, new Object[] { dto.getNombre(), dto.getUsername(), dto.getPwd(),
					dto.getUsuarioAlta(), dto.getEmail() }, Integer.class);

		} catch (Exception e) {
			log.error("{ }" + e);
			return 0;
		}

	}

	public Boolean updateUser(UsuarioDTO dto) {

		try {

			final String sql = "UPDATE public.usuario SET nombre = ?, username = ?, email = ? WHERE usuario_id = ?;";

			template.update(sql,
					new Object[] { dto.getNombre(), dto.getUsername(), dto.getEmail(), dto.getUsuarioId() });

			return true;
		} catch (Exception e) {
			log.error("{ }" + e);
			return false;
		}

	}

	public UsuarioDTO getById(Integer id) {

		try {

			final String query = "SELECT username, nombre, email, usuario_id FROM usuario WHERE usuario_id = ? and estatus = 1;";

			List<UsuarioDTO> lst = template.query(query, new Object[] { id },
					new BeanPropertyRowMapper<UsuarioDTO>(UsuarioDTO.class));

			return lst.size() > 0 ? lst.get(0) : null;

		} catch (EmptyResultDataAccessException e) {
			log.error("Ocurrio un error al obtener el getByIdSession: ", e);
			return null;
		}
	}

	public Boolean removeUser(Long id) {

		try {

			final String sql = "UPDATE public.usuario SET estatus = 0 WHERE usuario_id = ?;";

			template.update(sql, new Object[] { id });

			return true;
		} catch (Exception e) {
			log.error("{ }" + e);
			return false;
		}

	}

}
