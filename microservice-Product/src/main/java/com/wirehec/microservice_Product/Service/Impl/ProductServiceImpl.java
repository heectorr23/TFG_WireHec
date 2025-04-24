package com.wirehec.microservice_Product.Service.Impl;

import com.wirehec.microservice_Product.Repository.ProductRepository;
import com.wirehec.microservice_Product.Service.Inter.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;
}
