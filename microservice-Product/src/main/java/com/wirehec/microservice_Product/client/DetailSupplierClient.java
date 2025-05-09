package com.wirehec.microservice_Product.client;

import com.wirehec.microservice_Product.Controller.DTO.DetailSupplierDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-suppliers", url = "localhost:8086/api/Detailsupplier")
public interface DetailSupplierClient {

    @GetMapping("/findAllSuplierProducts/{idProduct}")
    List<DetailSupplierDTO> findByIdProducts(@PathVariable Long idProduct); // Assuming the method returns a list of objects, adjust the type as needed
}

