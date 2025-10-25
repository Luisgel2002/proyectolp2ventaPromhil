package com.proyecto_promhil.proyecto_promhil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto_promhil.proyecto_promhil.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
