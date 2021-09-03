package com.mx.kikoya.services.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class UserResponse extends BaseResponse {

	private static final long serialVersionUID = 600277502275122619L;

	private String email;

	private String name;

	private String username;

	private Integer userId;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public UserResponse() {
		super();
	}

	public UserResponse(String estatus, String mensaje) {
		super(estatus, mensaje);
	}

	public UserResponse(String estatus, String mensaje, Integer userId) {
		super(estatus, mensaje);
		this.userId = userId;
	}

	public UserResponse(String estatus, String mensaje, String email, String name, String username, Integer userId) {
		super(estatus, mensaje);
		this.email = email;
		this.name = name;
		this.username = username;
		this.userId = userId;
	}

}
