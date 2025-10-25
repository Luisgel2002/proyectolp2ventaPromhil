package com.proyecto_promhil.proyecto_promhil.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyecto_promhil.proyecto_promhil.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findByEstadoTrue();
    List<Producto> findByCategoria_IdCategoriaAndEstadoTrue(Integer idCategoria);
    long countByCategoria_IdCategoria(Integer idCategoria);
}
