package com.wirehec.microservice_Bill.Client;


import com.wirehec.microservice_Bill.Controller.DTO.EmployeeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-employee", url = "localhost:8084/api/employee")
@Component
public interface EmployeeClient {
    @GetMapping("/findAllEmployeeBill/{idBill}")
    List<EmployeeDTO> findByBills(@PathVariable Long idBill);
}
