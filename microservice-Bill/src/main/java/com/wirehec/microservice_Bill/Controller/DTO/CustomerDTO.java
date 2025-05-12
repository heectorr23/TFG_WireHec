package com.wirehec.microservice_Bill.Controller.DTO;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDTO {

    private String name;

    private String contacto;

    private int telefono;

    private String identificacion;

    private String email;

    private String zona;

    private String direccion;

}
