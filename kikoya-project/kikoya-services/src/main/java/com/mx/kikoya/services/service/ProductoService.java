package com.mx.kikoya.services.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.kikoya.services.dao.ProductoDAO;
import com.mx.kikoya.services.dto.ProductoDTO;
import com.mx.kikoya.services.request.ProductRequest;
import com.mx.kikoya.services.response.BaseResponse;
import com.mx.kikoya.services.response.ProductResponse;

@Service
public class ProductoService {

	@Autowired
	private ProductoDAO productoDao;

	public ProductResponse saveProduct(ProductRequest request, Integer id) {

		Integer userId = productoDao
				.saveProducto(new ProductoDTO(request.getName(), request.getPrice(), request.getBrand(), null));

		return (userId > 0) ? new ProductResponse("ok", "Operacion exitosa", userId)
				: new ProductResponse("ko", "Contacte al Administrador");

	}

	public BaseResponse editProduct(ProductRequest request, Integer id) {

		try {
			if (productoDao.updateProducto(
					new ProductoDTO(request.getName(), request.getPrice(), request.getBrand(), request.getProductId())))
				return new BaseResponse("ok", "Operacion exitosa");
			else
				return new BaseResponse("ko", "Ocurrio un error al actualizar");
		} catch (Exception e) {
			return new BaseResponse("ko", "Contacte al Administrador");
		}

	}

	public ProductResponse findById(Integer id) {

		try {
			ProductoDTO dto = productoDao.getById(id);

			if (dto != null)
				return new ProductResponse("ok", "Operacion exitosa", dto.getNombre(), dto.getProductoId(),
						dto.getPrecio(), dto.getMarca());

			else
				return new ProductResponse("ok", "Sin resultados");

		} catch (Exception e) {
			return new ProductResponse("ko", "Contacte al Administrador");
		}

	}

	public BaseResponse removeById(Integer id) {
		try {
			if (productoDao.removeProduct(id))
				return new BaseResponse("ok", "Operacion exitosa");
			else
				return new BaseResponse("ko", "Ocurrio un error al remover el producto");
		} catch (Exception e) {
			return new BaseResponse("ko", "Contacte al Administrador");
		}
	}
}
