package com.wirehec.microservice_Supplier.Service.Impl;

import com.wirehec.microservice_Supplier.Repository.SupplierRepository;
import com.wirehec.microservice_Supplier.Service.Inter.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl implements ISupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

}
