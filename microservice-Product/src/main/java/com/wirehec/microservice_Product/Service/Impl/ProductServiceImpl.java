package com.wirehec.microservice_Product.Service.Impl;

import com.wirehec.microservice_Product.Controller.DTO.SupplierDTO;
import com.wirehec.microservice_Product.HTTP.Response.SuplierByProductResponse;
import com.wirehec.microservice_Product.Repository.ProductRepository;
import com.wirehec.microservice_Product.Service.Inter.IProductService;
import com.wirehec.microservice_Product.client.SupplierClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SupplierClient supplierClient;

    @Override
    public SuplierByProductResponse findAll() {
        List<SupplierDTO> supplierDTOList = supplierClient.findAll();
        return SuplierByProductResponse.builder()
                .id()
                .build();
    }
}
