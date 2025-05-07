package com.wirehec.microservice_Product.Service.Inter;

import com.wirehec.microservice_Product.HTTP.Response.DetailSuplierByProductResponse;

;

public interface IProductService {

    DetailSuplierByProductResponse findProductBySupplier(Long idProduct);

}