package com.mx.kikoya.services.dto;

import java.io.Serializable;

public class ProductoDTO implements Serializable {

	private static final long serialVersionUID = 6714786233992108516L;

	private Integer productoId;

	private String nombre;

	private String precio;

	private String marca;

	private Integer estatus;

	public Integer getProductoId() {
		return productoId;
	}

	public void setProductoId(Integer productoId) {
		this.productoId = productoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public ProductoDTO() {
		super();
	}

	public ProductoDTO(String nombre, String precio, String marca, Integer productoId) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.marca = marca;
		this.productoId = productoId;
	}

}
