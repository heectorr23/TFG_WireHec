package com.wirehec.microservice_Supplier.Service.Impl;

import com.wirehec.microservice_Supplier.Repository.SupplierOrderRepository;
import com.wirehec.microservice_Supplier.Service.Inter.ISupplierOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierOrderServiceImpl implements ISupplierOrderService {

    @Autowired
    private SupplierOrderRepository supplierOrderRepository;
}
