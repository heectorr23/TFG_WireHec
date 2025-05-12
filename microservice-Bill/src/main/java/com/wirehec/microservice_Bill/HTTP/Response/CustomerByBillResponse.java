package com.wirehec.microservice_Bill.HTTP.Response;

import com.wirehec.microservice_Bill.Controller.DTO.CustomerDTO;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerByBillResponse {

    private Long id;
    private BigDecimal precio;
    private String zona;
    private String direccion;
    private List<CustomerDTO> customers;
}

