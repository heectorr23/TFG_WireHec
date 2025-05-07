package com.wirehec.microservice_Product.Controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailSupplierDTO {
    private Long idDetalleProveedor;
    private SupplierDTO supplierEntity;
    private SupplierOrderDTO supplierOrderEntity;
    private Long idProduct;
    // Puedes añadir un campo para las órdenes si es necesario
}