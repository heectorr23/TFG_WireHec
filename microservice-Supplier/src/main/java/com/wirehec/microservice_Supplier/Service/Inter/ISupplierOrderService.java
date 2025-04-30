package com.wirehec.microservice_Supplier.Service.Inter;

import com.wirehec.microservice_Supplier.Entity.SupplierOrderEntity;

import java.util.List;

public interface ISupplierOrderService {
    List<SupplierOrderEntity> findAll();

    SupplierOrderEntity saveSupplierOrder(SupplierOrderEntity supplierOrderEntity);

    SupplierOrderEntity updateSupplierOrder(Long id, SupplierOrderEntity supplierOrderEntity);

    void deleteSupplierOrder(Long id);
}
