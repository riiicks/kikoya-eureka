package com.mx.kikoya.services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mx.kikoya.services.request.UserRequest;
import com.mx.kikoya.services.response.BaseResponse;
import com.mx.kikoya.services.service.UsuarioService;

@RestController
@RequestMapping("/unsecured")
public class RegistroController {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping("/registro")
	public @ResponseBody ResponseEntity<BaseResponse> registroUsuario(@RequestBody UserRequest request) {

		BaseResponse response = usuarioService.saveUser(request, null);

		if (response.getEstatus().equals("ok"))
			return new ResponseEntity<>(response, HttpStatus.OK);
		else
			return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);

	}

}
