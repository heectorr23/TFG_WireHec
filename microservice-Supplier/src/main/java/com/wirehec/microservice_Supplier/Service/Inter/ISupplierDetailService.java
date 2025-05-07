package com.wirehec.microservice_Supplier.Service.Inter;

import com.wirehec.microservice_Supplier.Entity.SupplierDetailEntity;

import java.util.List;

public interface ISupplierDetailService {

    List<SupplierDetailEntity> findByIdProduct(Long idProduct);
}
