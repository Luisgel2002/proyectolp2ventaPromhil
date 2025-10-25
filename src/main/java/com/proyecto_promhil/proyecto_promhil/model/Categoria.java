package com.proyecto_promhil.proyecto_promhil.model;

import org.hibernate.annotations.DynamicInsert;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "categorias")
@DynamicInsert
@Getter @Setter
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "nombre_categoria")
    private String nombreCategoria;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado", nullable = false)
    private Boolean estado = true;

    @Override
    public String toString() {
        return descripcion;
    }
}
