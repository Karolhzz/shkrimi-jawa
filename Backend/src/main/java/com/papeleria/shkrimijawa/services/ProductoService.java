package com.papeleria.shkrimijawa.services;

import java.util.List;
import java.util.Optional;

import com.papeleria.shkrimijawa.model.Producto;



public interface ProductoService {
	
	public List<Producto> consultarProducto();
	public Optional<Producto> consultarProductoPorId(Long id);
	public Producto crearProducto(Producto producto);
	public Producto actualizarProducto(Producto producto);
	public void eliminarProductoPorId(Long id);

}
