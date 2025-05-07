package com.wirehec.microservice_Supplier.Service.Impl;

import com.wirehec.microservice_Supplier.Entity.SupplierDetailEntity;
import com.wirehec.microservice_Supplier.Repository.SupplierDetailRepository;
import com.wirehec.microservice_Supplier.Service.Inter.ISupplierDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierDetailServiceImpl implements ISupplierDetailService {

    @Autowired
    private SupplierDetailRepository supplierDetailRepository;

    @Override
    public List<SupplierDetailEntity> findByIdProduct(Long idProduct) {
        return supplierDetailRepository.findByIdProduct(idProduct);
    }
}
