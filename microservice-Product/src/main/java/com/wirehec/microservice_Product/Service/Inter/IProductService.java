package com.wirehec.microservice_Product.Service.Inter;

import com.wirehec.microservice_Product.Entity.ProductEntity;

import java.util.List;

public interface IProductService {
    List<ProductEntity> findByIdProveedor(Long idProveedor);

}