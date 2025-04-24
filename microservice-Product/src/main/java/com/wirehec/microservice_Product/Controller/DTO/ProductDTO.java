package com.wirehec.microservice_Product.Controller.DTO;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private Long id;

    private String nombreProducto;

    private String categoriaProducto;

    private BigDecimal precioVenta;

    private int stock;

    private BigDecimal precioCoste;
}
