package com.proyecto_promhil.proyecto_promhil.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "compras")
@Getter @Setter
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Integer idCompra;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    
    
    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;

  
    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    @NotNull
    @Column(name = "total", nullable = false, precision = 10, scale = 2)
    private BigDecimal total;
}
