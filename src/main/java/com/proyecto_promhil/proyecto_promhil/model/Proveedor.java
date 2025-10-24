package com.proyecto_promhil.proyecto_promhil.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "proveedores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Integer id;

    @NotBlank
    @Size(max = 100)
    @Column(name = "nombre_preveedor", nullable = false, length = 100)
    private String nombre;

    @NotBlank
    @Size(max = 100)
    @Column(name = "contacto", nullable = false, length = 100)
    private String contacto;

    @NotBlank
    @Size(max = 9)
    @Column(name = "telefono_provee", nullable = false, length = 9)
    private String telefono;

    @NotBlank
    @Size(max = 100)
    @Column(name = "direccion", nullable = false, length = 100)
    private String direccion;
}
