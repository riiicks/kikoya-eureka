package com.mx.kikoya.services.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ProductResponse extends BaseResponse {

	private static final long serialVersionUID = -9072719768321657363L;

	private String name;

	private Integer productId;

	private String price;

	private String brand;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public ProductResponse() {
		super();
	}

	public ProductResponse(String estatus, String mensaje) {
		super(estatus, mensaje);
	}

	public ProductResponse(String estatus, String mensaje, Integer productId) {
		super(estatus, mensaje);
		this.productId = productId;
	}

	public ProductResponse(String estatus, String mensaje, String name, Integer productId, String price, String brand) {
		super(estatus, mensaje);
		this.name = name;
		this.productId = productId;
		this.price = price;
		this.brand = brand;
	}

}
