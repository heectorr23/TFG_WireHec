package com.wirehec.microservice_Product.Controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SupplierDTO {
    private Long idProveedor;
    private String nombreProveedor;
    private int cifProveedor;
    private String emailProveedor;
    private String categoriaProveedor;
    private String productoProveedor;
}