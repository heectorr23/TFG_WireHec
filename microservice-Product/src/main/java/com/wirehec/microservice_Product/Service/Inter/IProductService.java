package com.wirehec.microservice_Product.Service.Inter;

import com.wirehec.microservice_Product.Entity.ProductEntity;
import com.wirehec.microservice_Product.HTTP.Response.SuplierByProductResponse;

import java.util.List;

public interface IProductService {
    SuplierByProductResponse findAll();

}