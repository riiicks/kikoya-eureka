package com.mx.kikoya.services.response;

import java.io.Serializable;

public class BaseResponse implements Serializable {

	private static final long serialVersionUID = -2777165598297946959L;

	private String estatus;

	private String mensaje;

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public BaseResponse() {
		super();
	}

	public BaseResponse(String estatus, String mensaje) {
		super();
		this.estatus = estatus;
		this.mensaje = mensaje;
	}

}
