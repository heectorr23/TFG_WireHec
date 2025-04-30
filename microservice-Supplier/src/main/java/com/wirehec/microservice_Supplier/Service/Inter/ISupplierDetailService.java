package com.wirehec.microservice_Supplier.Service.Inter;

import com.wirehec.microservice_Supplier.Entity.SupplierDetailEntity;

import java.util.List;

public interface ISupplierDetailService {

    List<SupplierDetailEntity> findAll();

    SupplierDetailEntity saveSupplierDetail(SupplierDetailEntity supplierDetailEntity);

    SupplierDetailEntity updateSupplierDetail(Long id, SupplierDetailEntity supplierDetailEntity);

    void deleteSupplierDetail(Long id);
}

