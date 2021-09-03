package com.mx.kikoya.services.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mx.kikoya.services.dao.UsuarioDAO;
import com.mx.kikoya.services.dto.UsuarioDTO;
import com.mx.kikoya.services.request.UserRequest;
import com.mx.kikoya.services.response.BaseResponse;
import com.mx.kikoya.services.response.UserResponse;

@Service
public class UsuarioService {

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private UsuarioDAO userDao;

	public UserResponse saveUser(UserRequest request, Integer id) {

		try {

			Pattern pattern = Pattern.compile(
					"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

			Matcher mather = pattern.matcher(request.getEmail());

			if (mather.find() == true) {
				Integer userId = userDao.saveUsuario(new UsuarioDTO(request.getName(), request.getUsername(),
						bCryptPasswordEncoder.encode(request.getPassword()), request.getEmail(), id));

				return (userId > 0) ? new UserResponse("ok", "Operacion exitosa", userId)
						: new UserResponse("ko", "Contacte al Administrador");

			} else
				return new UserResponse("ko", "No tiene un formato valido el email");

		} catch (Exception e) {
			return new UserResponse("ko", "Contacte al Administrador");
		}

	}

	public BaseResponse updateUser(UserRequest request, Integer id) {

		try {
			if (userDao.updateUser(
					new UsuarioDTO(request.getName(), request.getUsername(), request.getEmail(), request.getUserId())))
				return new BaseResponse("ok", "Operacion exitosa");
			else
				return new BaseResponse("ko", "Ocurrio un error al actualizar");
		} catch (Exception e) {
			return new BaseResponse("ko", "Contacte al Administrador");
		}

	}

	public UserResponse findById(Integer id) {

		try {
			UsuarioDTO dto = userDao.getById(id);

			if (dto != null)
				return new UserResponse("ok", "Operacion exitosa", dto.getEmail(), dto.getNombre(), dto.getUsername(),
						dto.getUsuarioId());

			else
				return new UserResponse("ok", "Sin resultados");

		} catch (Exception e) {
			return new UserResponse("ko", "Contacte al Administrador");
		}
	}

	public BaseResponse removeById(Long id) {

		try {
			if (userDao.removeUser(id))
				return new BaseResponse("ok", "Operacion exitosa");
			else
				return new BaseResponse("ko", "Ocurrio un error al remover el usuario");
		} catch (Exception e) {
			return new BaseResponse("ko", "Contacte al Administrador");
		}
	}

}
