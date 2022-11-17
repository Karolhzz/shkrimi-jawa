package com.papeleria.shkrimijawa.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.papeleria.shkrimijawa.model.Producto;
import com.papeleria.shkrimijawa.services.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Producto producto){
		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.crearProducto(producto));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Long id){
		Optional<Producto> producto = productoService.consultarProductoPorId(id);
		if(!producto.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		return ResponseEntity.ok(producto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Producto productoDetalle, @PathVariable Long id){
		Optional<Producto> producto = productoService.consultarProductoPorId(id);
		if(!producto.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		BeanUtils.copyProperties(productoDetalle, producto.get());
		producto.get().setId(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.actualizarProducto(producto.get()));
	}
	
	@PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updatePartial(@RequestBody JsonPatch patch, @PathVariable Long id){
		try {
			Optional<Producto> producto = productoService.consultarProductoPorId(id);
			if(!producto.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode patched = patch.apply(objectMapper.convertValue(producto.get(), JsonNode.class));
		    Producto productoPatched = objectMapper.treeToValue(patched, Producto.class);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(productoService.actualizarProducto(productoPatched));
	    } catch (JsonPatchException | JsonProcessingException e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    } 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Optional<Producto> producto = productoService.consultarProductoPorId(id);
		if(!producto.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		productoService.eliminarProductoPorId(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<Producto> readAll(){
		List<Producto> productos = StreamSupport
				.stream(productoService.consultarProducto().spliterator(), false)
				.collect(Collectors.toList());
		return productos;
	}
}
