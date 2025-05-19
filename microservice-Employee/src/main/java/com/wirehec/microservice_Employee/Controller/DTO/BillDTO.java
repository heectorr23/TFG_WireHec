package com.wirehec.microservice_Employee.Controller.DTO;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillDTO {

    private Long id;
    private BigDecimal Precio;
    private String Zona;
    private String Direccion;
}
