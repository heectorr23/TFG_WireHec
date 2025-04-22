package com.wirehec.microservice_Product.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Producto")
@EqualsAndHashCode
@ToString
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "IdProducto")
    private Long id;

    @Column(name= "NombreProducto")
    private String nombreProducto;

    @Column(name="CategoriaProducto")
    private String categoriaProducto;

    @Column(name= "PrecioVenta")
    private BigDecimal precioVenta;

    @Column(name= "Stock")
    private int stock;

    @Column(name= "PrecioCoste")
    private BigDecimal precioCoste;
}
