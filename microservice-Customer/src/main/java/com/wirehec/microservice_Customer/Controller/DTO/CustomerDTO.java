package com.wirehec.microservice_Customer.Controller.DTO;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CustomerDTO {
    private Long id;

    private String name;

    private String contacto;

    private int telefono;

    private String identificacion;

    private String email;

    private String zona;

    private String direccion;

}

