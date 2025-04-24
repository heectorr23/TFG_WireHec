package com.wirehec.microservice_Supplier.Service.Impl;

import com.wirehec.microservice_Supplier.Repository.SupplierDetailRepository;
import com.wirehec.microservice_Supplier.Service.Inter.ISupplierDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierDetailServiceImpl implements ISupplierDetailService {

    @Autowired
    private SupplierDetailRepository supplierDetailRepository;
}
