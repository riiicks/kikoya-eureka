package com.mx.kikoya.services.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mx.kikoya.services.request.UserRequest;
import com.mx.kikoya.services.response.BaseResponse;
import com.mx.kikoya.services.response.UserResponse;
import com.mx.kikoya.services.security.CustomUserDetails;
import com.mx.kikoya.services.service.UsuarioService;

@RestController
@RequestMapping("/user")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody ResponseEntity<BaseResponse> createProduct(Authentication authentication,
			@RequestBody UserRequest request) throws IOException {

		CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();

		BaseResponse response = usuarioService.saveUser(request, user.getId());

		if (response.getEstatus().equals("ok"))
			return new ResponseEntity<>(response, HttpStatus.OK);

		else
			return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);

	}

	@RequestMapping(value = "/edit", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public @ResponseBody ResponseEntity<BaseResponse> editUser(Authentication authentication,
			@RequestBody UserRequest request) throws IOException {

		CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();

		BaseResponse response = usuarioService.updateUser(request, user.getId());

		if (response.getEstatus().equals("ok"))
			return new ResponseEntity<>(response, HttpStatus.OK);

		else
			return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);

	}

	@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ResponseEntity<UserResponse> findById(@PathVariable("id") Integer id) throws IOException {

		UserResponse response = usuarioService.findById(id);

		if (response.getEstatus().equals("ok"))
			return new ResponseEntity<>(response, HttpStatus.OK);

		else
			return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);

	}

	@RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody ResponseEntity<BaseResponse> removeById(@PathVariable("id") Long id) throws IOException {

		BaseResponse response = usuarioService.removeById(id);

		if (response.getEstatus().equals("ok"))
			return new ResponseEntity<>(response, HttpStatus.OK);

		else
			return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);

	}

}
