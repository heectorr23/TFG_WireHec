package com.wirehec.microservice_Product.Service.Inter;

import com.wirehec.microservice_Product.Entity.ProductEntity;
import com.wirehec.microservice_Product.HTTP.Response.DetailSuplierByProductResponse;

import java.util.List;

public interface IProductService {

    List<ProductEntity> findAll();

    ProductEntity saveProduct(ProductEntity productEntity);

    void deleteProduct(Long id);

    DetailSuplierByProductResponse findProductBySupplier(Long idProduct);

}