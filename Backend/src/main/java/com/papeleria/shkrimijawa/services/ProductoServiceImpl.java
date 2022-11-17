package com.papeleria.shkrimijawa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.papeleria.shkrimijawa.model.Producto;
import com.papeleria.shkrimijawa.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	ProductoRepository repositorio;
	
	
	public List<Producto> consultarProducto() {
		return repositorio.findAll();
	}

	@Override
	public Optional<Producto> consultarProductoPorId(Long id) {
		return repositorio.findById(id);
	}
	

	@Override
	public Producto crearProducto(Producto producto) {	
		return repositorio.insert(producto);
	}
	

	@Override
	public Producto actualizarProducto(Producto producto) {
		return repositorio.save(producto);
	}

	@Override
	public void eliminarProductoPorId(Long id) {
		repositorio.deleteById(id);


	}

}
