package com.wirehec.microservice_Product.client;

import com.wirehec.microservice_Product.Controller.DTO.SupplierDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "msvc-suppliers", url = "localhost:8086/api/supplier")
public interface SupplierClient {

    @GetMapping("/findAll")
    List<SupplierDTO> findAll();
}
