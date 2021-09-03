package com.mx.kikoya.services.dto;

import java.io.Serializable;
import java.util.Date;

public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = -94534658661688547L;

	private Integer usuarioId;

	private String email;

	private String nombre;

	private String username;

	private String pwd;

	private Date fechaAlta;

	private Integer usuarioAlta;

	private Integer estatus;

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Integer getUsuarioAlta() {
		return usuarioAlta;
	}

	public void setUsuarioAlta(Integer usuarioAlta) {
		this.usuarioAlta = usuarioAlta;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(String nombre, String username, String pwd, String email, Integer usuarioAlta) {
		super();
		this.nombre = nombre;
		this.username = username;
		this.pwd = pwd;
		this.usuarioAlta = usuarioAlta;
		this.email = email;
	}

	public UsuarioDTO(String nombre, String username, String email, Integer usuarioId) {
		super();
		this.nombre = nombre;
		this.username = username;
		this.email = email;
		this.usuarioId = usuarioId;
	}

}
