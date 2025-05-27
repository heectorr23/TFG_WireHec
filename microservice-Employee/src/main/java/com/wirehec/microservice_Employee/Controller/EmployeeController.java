package com.wirehec.microservice_Employee.Controller;

import com.wirehec.microservice_Employee.Controller.DTO.EmployeeDTO;
import com.wirehec.microservice_Employee.Entity.EmployeeEntity;
import com.wirehec.microservice_Employee.Entity.RoleEntity;
import com.wirehec.microservice_Employee.Entity.ERole;
import com.wirehec.microservice_Employee.Service.Impl.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employee")
@Slf4j
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        List<EmployeeDTO> employeeDTOs = employeeService.findAll()
                .stream()
                .map(employee -> EmployeeDTO.builder()
                        .idEmpleado(employee.getId())
                        .nombreEmpleado(employee.getNombreEmpleado())
                        .nifEmpleado(employee.getNifEmpleado())
                        .telefonoEmpleado(employee.getTelefonoEmpleado())
                        .email(employee.getEmail())
                        .passwordEmpleado(employee.getPasswordEmpleado())
                        .roles(employee.getRoles())
                        .beneficioEmpleado(employee.getBeneficioEmpleado())
                        .horaEntrada(employee.getHoraEntrada())
                        .horaSalida(employee.getHoraSalida())
                        .salario(employee.getSalario())
                        .build()
                )
                .toList();
        return ResponseEntity.ok(employeeDTOs);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = EmployeeEntity.builder()
                .id(employeeDTO.getIdEmpleado())
                .nombreEmpleado(employeeDTO.getNombreEmpleado())
                .nifEmpleado(employeeDTO.getNifEmpleado())
                .email(employeeDTO.getEmail())
                .passwordEmpleado(passwordEncoder.encode(employeeDTO.getPasswordEmpleado()))
                .roles(employeeDTO.getRoles().stream()
                        .map(role -> RoleEntity.builder()
                                .name(Enum.valueOf(ERole.class, role.getName().name()))
                                .build())
                        .collect(Collectors.toSet()))
                .beneficioEmpleado(employeeDTO.getBeneficioEmpleado())
                .horaEntrada(employeeDTO.getHoraEntrada())
                .horaSalida(employeeDTO.getHoraSalida())
                .salario(employeeDTO.getSalario())
                .build();
        EmployeeEntity savedEmployee = employeeService.saveEmployee(employeeEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = EmployeeEntity.builder()
                .id(id)
                .nombreEmpleado(employeeDTO.getNombreEmpleado())
                .nifEmpleado(employeeDTO.getNifEmpleado())
                .email(employeeDTO.getEmail())
                .passwordEmpleado(passwordEncoder.encode(employeeDTO.getPasswordEmpleado()))
                .roles(employeeDTO.getRoles()) // Usar directamente los roles
                .beneficioEmpleado(employeeDTO.getBeneficioEmpleado())
                .horaEntrada(employeeDTO.getHoraEntrada())
                .horaSalida(employeeDTO.getHoraSalida())
                .salario(employeeDTO.getSalario())
                .build();
        EmployeeEntity updatedEmployee = employeeService.saveEmployee(employeeEntity);
        return ResponseEntity.ok(updatedEmployee);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}