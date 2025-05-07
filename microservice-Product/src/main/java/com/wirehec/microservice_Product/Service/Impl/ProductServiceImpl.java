package com.wirehec.microservice_Product.Service.Impl;

import com.wirehec.microservice_Product.Controller.DTO.DetailSupplierDTO;
import com.wirehec.microservice_Product.Entity.ProductEntity;
import com.wirehec.microservice_Product.HTTP.Response.DetailSuplierByProductResponse;
import com.wirehec.microservice_Product.Repository.ProductRepository;
import com.wirehec.microservice_Product.Service.Inter.IProductService;
import com.wirehec.microservice_Product.client.DetailSupplierClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DetailSupplierClient detailSupplierClient;

    @Override
    public DetailSuplierByProductResponse findProductBySupplier(Long idProduct) {

        //consultar el producto
        ProductEntity product = productRepository.findById(idProduct).orElseThrow();

        List<DetailSupplierDTO> supplierDTOList = detailSupplierClient.findByIdProducts(idProduct);

        return DetailSuplierByProductResponse.builder()
                .id(product.getId())
                .nombreProducto(product.getNombreProducto())
                .categoriaProducto(product.getCategoriaProducto())
                .precioVenta(product.getPrecioVenta())
                .stock(product.getStock())
                .precioCoste(product.getPrecioCoste())
                .suppliers(supplierDTOList)
                .build();
    }
}
