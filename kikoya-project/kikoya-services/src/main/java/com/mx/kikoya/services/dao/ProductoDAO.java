package com.mx.kikoya.services.dao;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.mx.kikoya.services.dto.ProductoDTO;

@Repository
public class ProductoDAO extends GenericDAO {

	public Integer saveProducto(ProductoDTO dto) {

		try {

			final String sql = "INSERT INTO public.producto (nombre, precio, marca) VALUES(?, ?, ?)RETURNING producto_id;";

			return template.queryForObject(sql, new Object[] { dto.getNombre(), dto.getPrecio(), dto.getMarca() },
					Integer.class);

		} catch (Exception e) {
			log.error("{ }" + e);
			return 0;
		}

	}

	public Boolean updateProducto(ProductoDTO dto) {

		try {

			final String sql = "UPDATE public.producto SET nombre = ?, precio = ?, marca = ? WHERE producto_id = ?;";

			template.update(sql,
					new Object[] { dto.getNombre(), dto.getPrecio(), dto.getMarca(), dto.getProductoId() });

			return true;
		} catch (Exception e) {
			log.error("{ }" + e);
			return false;
		}

	}

	public ProductoDTO getById(Integer id) {

		try {

			final String query = "SELECT nombre, precio, marca, producto_id FROM producto WHERE producto_id = ? and estatus = 1;";

			List<ProductoDTO> lst = template.query(query, new Object[] { id },
					new BeanPropertyRowMapper<ProductoDTO>(ProductoDTO.class));

			return lst.size() > 0 ? lst.get(0) : null;

		} catch (EmptyResultDataAccessException e) {
			log.error("Ocurrio un error al obtener el getByIdSession: ", e);
			return null;
		}
	}

	public Boolean removeProduct(Integer id) {

		try {

			final String sql = "UPDATE public.producto SET estatus = 0 WHERE producto_id = ?;";

			template.update(sql, new Object[] { id });

			return true;
		} catch (Exception e) {
			log.error("{ }" + e);
			return false;
		}

	}
}
