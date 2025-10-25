package com.proyecto_promhil.proyecto_promhil.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ventas")
@Getter @Setter
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Integer idVenta;

  
    @Column(name = "fecha")
    private LocalDate fecha;
    
    @NotNull
    @Column(name = "total", nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

  
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    
    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "id_metodo")
    private MetodoPago metodoPago;

   
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    
   
}
