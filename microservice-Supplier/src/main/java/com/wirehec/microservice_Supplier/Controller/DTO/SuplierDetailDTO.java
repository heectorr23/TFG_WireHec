package com.wirehec.microservice_Supplier.Controller.DTO;

import com.wirehec.microservice_Supplier.Entity.SupplierEntity;
import com.wirehec.microservice_Supplier.Entity.SupplierOrderEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SuplierDetailDTO {

    private Long  idDetalleProveedor;

    private SupplierEntity supplierEntity;

    private Set<SupplierOrderEntity> supplierOrderEntities;

    private Long idProduct;
}
