package com.papeleria.shkrimijawa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.papeleria.shkrimijawa.model.Producto;

@Repository
public interface ProductoRepository extends MongoRepository<Producto, Long> {

}
