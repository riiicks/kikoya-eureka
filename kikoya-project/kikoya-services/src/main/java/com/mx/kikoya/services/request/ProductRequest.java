package com.mx.kikoya.services.request;

import java.io.Serializable;

public class ProductRequest implements Serializable {

	private static final long serialVersionUID = 2947808910631571764L;

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

}
