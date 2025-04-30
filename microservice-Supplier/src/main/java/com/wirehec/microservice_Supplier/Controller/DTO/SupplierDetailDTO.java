package com.wirehec.microservice_Supplier.Controller.DTO;

import com.wirehec.microservice_Supplier.Entity.SupplierEntity;
import com.wirehec.microservice_Supplier.Entity.SupplierOrderEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SupplierDetailDTO {

    private Long  idDetalleProveedor;

    private SupplierEntity supplierEntity;

    private Set<SupplierOrderEntity> supplierOrderEntities;
}
