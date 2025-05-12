package com.wirehec.microservice_Bill.Client;


import com.wirehec.microservice_Bill.Controller.DTO.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-customer", url = "localhost:8083/api/customer")
@Component
public interface CustomerClient {
    @GetMapping("/findAllCustomerBill/{idBill}")
    List<CustomerDTO> findByIdBills(@PathVariable Long idBill);
}

