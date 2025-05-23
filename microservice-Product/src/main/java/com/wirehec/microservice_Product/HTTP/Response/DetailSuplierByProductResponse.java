package com.wirehec.microservice_Product.HTTP.Response;


import com.wirehec.microservice_Product.Controller.DTO.DetailSupplierDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailSuplierByProductResponse {

    private Long id;
    private String nombreProducto;
    private String categoriaProducto;
    private BigDecimal precioVenta;
    private int stock;
    private BigDecimal precioCoste;
    private List<DetailSupplierDTO> suppliers;
}
