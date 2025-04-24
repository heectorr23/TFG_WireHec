package com.wirehec.microservice_Login.Controller.DTO;

import com.wirehec.microservice_Login.Entity.RoleEntity;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {

    private String nombreEmpleado;

    private String nifEmpleado;

    private int telefonoEmpleado;

    private String email;

    private String passwordEmpleado;

    private Set<RoleEntity> roles;

    private int beneficioEmpleado;

    private LocalDateTime horaEntrada = LocalDateTime.now();

    private LocalDateTime horaSalida = LocalDateTime.now();

    private BigDecimal salario;
}
