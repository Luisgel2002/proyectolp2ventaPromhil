package com.proyecto_promhil.proyecto_promhil.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer id;

    @NotBlank
    @Size(max = 100)
    @Column(name = "nombre_cliente", nullable = false, length = 100)
    private String nombre;

    @NotBlank
    @Email
    @Size(max = 100)
    @Column(name = "correo", nullable = false, length = 100)
    private String correo;

    @NotBlank
    @Size(max = 9)
    @Column(name = "telefono_cli", nullable = false, length = 9)
    private String telefono;

    @NotBlank
    @Size(max = 100)
    @Column(name = "direccion", nullable = false, length = 100)
    private String direccion;
}
