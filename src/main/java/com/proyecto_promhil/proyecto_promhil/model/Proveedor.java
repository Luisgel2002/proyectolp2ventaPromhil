package com.proyecto_promhil.proyecto_promhil.model;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "proveedores")
@DynamicInsert
@Getter @Setter
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Integer idProveedor;

    @Column(name = "nombre_proveedor")
    private String nombreProveedor;

 
    @Column(name = "contacto")
    private String contacto;

   
    @Column(name = "telefono_provee")
    private String telefono;

    
    @Column(name = "direccion")
    private String direccion;
}
