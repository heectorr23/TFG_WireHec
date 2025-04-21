package com.wirehec.microservice_Contability.Controller.DTO;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ContabilityDTO {

    private String name;

    private String contacto;

    private int telefono;

    private String identificacion;

    private String email;

    private String zona;

    private String direccion;

}