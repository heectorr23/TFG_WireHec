package com.wirehec.microservice_Employee.HTTP.response;

import com.wirehec.microservice_Employee.Controller.DTO.BillDTO;
import com.wirehec.microservice_Employee.Controller.DTO.EmployeeDTO;
import com.wirehec.microservice_Employee.Entity.RoleEntity;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillByEmployeeResponse {

    private String nombreEmpleado;

    private String nifEmpleado;

    private int telefonoEmpleado;

    private String email;

    private String username;

    private String passwordEmpleado;

    private Set<RoleEntity> roles;

    private int beneficioEmpleado;

    private LocalDateTime horaEntrada = LocalDateTime.now();

    private LocalDateTime horaSalida = LocalDateTime.now();

    private BigDecimal salario;

    private List<BillDTO> bills;
}
