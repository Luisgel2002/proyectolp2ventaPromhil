package com.proyecto_promhil.proyecto_promhil.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categorias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer id;

    @NotBlank
    @Size(max = 100)
    @Column(name = "nombre_categoria", nullable = false, length = 100)
    private String nombre;

    @NotBlank
    @Size(max = 150)
    @Column(name = "descripcion", nullable = false, length = 150)
    private String descripcion;
}
