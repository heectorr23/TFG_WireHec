package com.wirehec.microservice_Supplier.Service.Inter;

import com.wirehec.microservice_Supplier.Entity.SupplierEntity;

import java.util.List;

public interface ISupplierService {

    List<SupplierEntity> findAll();

    SupplierEntity saveSupplier(SupplierEntity supplierEntity);

    SupplierEntity updateSupplier(Long id, SupplierEntity supplierEntity);

    void deleteSupplier(Long id);
}
