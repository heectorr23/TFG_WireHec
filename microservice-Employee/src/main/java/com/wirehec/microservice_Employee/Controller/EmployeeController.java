package com.wirehec.microservice_Employee.Controller;

import com.wirehec.microservice_Employee.Controller.DTO.EmployeeDTO;
import com.wirehec.microservice_Employee.Entity.EmployeeEntity;
import com.wirehec.microservice_Employee.Service.Impl.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@Slf4j
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        List<EmployeeDTO> employeeDTOs = employeeService.findAll()
                .stream()
                .map(employee -> EmployeeDTO.builder()
                        .nombreEmpleado(employee.getNombreEmpleado())
                        .nifEmpleado(employee.getNifEmpleado())
                        .telefonoEmpleado(employee.getTelefonoEmpleado())
                        .email(employee.getEmail())
                        .passwordEmpleado(employee.getPasswordEmpleado())
                        .roles(employee.getRoles())
                        .beneficioEmpleado(employee.getBeneficioEmpleado())
                        .horaEntrada(employee.getHoraEntrada())
                        .horaSalida((employee.getHoraSalida()))
                        .salario((employee.getSalario()))
                        .build()
                )
                .toList(); // Collect the stream into a list
        return ResponseEntity.ok(employeeDTOs);
    }
    @PostMapping("/save")
    public ResponseEntity<?> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = EmployeeEntity.builder()
                .nombreEmpleado(employeeDTO.getNombreEmpleado())
                .nifEmpleado(employeeDTO.getNifEmpleado())
                .email(employeeDTO.getEmail())
                .passwordEmpleado(employeeDTO.getPasswordEmpleado())
                .roles(employeeDTO.getRoles())
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
                .passwordEmpleado(employeeDTO.getPasswordEmpleado())
                .roles(employeeDTO.getRoles())
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