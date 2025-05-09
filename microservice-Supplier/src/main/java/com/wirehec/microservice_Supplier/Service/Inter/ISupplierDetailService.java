package com.wirehec.microservice_Supplier.Service.Inter;

public interface ISupplierDetailService {

    List<SupplierDetailEntity> findAll();

    SupplierDetailEntity saveSupplierDetail(SupplierDetailEntity supplierDetailEntity);

    SupplierDetailEntity updateSupplierDetail(Long id, SupplierDetailEntity supplierDetailEntity);

    void deleteSupplierDetail(Long id);

    List<SupplierDetailEntity> findByIdProduct(Long idProduct);
}
