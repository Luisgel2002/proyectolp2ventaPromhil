package com.proyecto_promhil.proyecto_promhil.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "metodos_pago")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_metodo")
    private Integer id;

    @NotBlank
    @Size(max = 50)
    @Column(name = "tipo_metodo", nullable = false, length = 50)
    private String tipo;

    @NotBlank
    @Size(max = 100)
    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;
}
