package com.wirehec.microservice_Employee.Client;

import com.wirehec.microservice_Employee.Controller.DTO.BillDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-bill", url = "localhost:8082/api/bill")
@Component
public interface BillClient {
    @GetMapping("/findAllBillEmployee/{idEmployee}")
    List<BillDTO> findByIdEmployees(@PathVariable Long idEmployee);
}
