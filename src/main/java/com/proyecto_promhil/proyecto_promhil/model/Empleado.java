package com.proyecto_promhil.proyecto_promhil.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "empleados")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Integer id;

    @NotBlank
    @Size(max = 100)
    @Column(name = "nombre_empleado", nullable = false, length = 100)
    private String nombre;

    @NotBlank
    @Size(max = 50)
    @Column(name = "cargo", nullable = false, length = 50)
    private String cargo;

    @NotBlank
    @Email
    @Size(max = 100)
    @Column(name = "correo", nullable = false, length = 100)
    private String correo;

    @NotBlank
    @Size(max = 9)
    @Column(name = "telefono_emple", nullable = false, length = 9)
    private String telefono;
}
