package com.wirehec.microservice_Employee.Service.Impl;

import com.wirehec.microservice_Employee.Client.BillClient;
import com.wirehec.microservice_Employee.Controller.DTO.BillDTO;
import com.wirehec.microservice_Employee.Entity.EmployeeEntity;
import com.wirehec.microservice_Employee.HTTP.response.BillByEmployeeResponse;
import com.wirehec.microservice_Employee.Repository.EmployeeRepository;
import com.wirehec.microservice_Employee.Service.Inter.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private BillClient billClient;

    @Override
    public List<EmployeeEntity> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    @Override
    public EmployeeEntity updateEmployee(Long id, EmployeeEntity employeeEntity) {
        EmployeeEntity existingEmployee = employeeRepository.findById(id).orElseThrow();
        existingEmployee.setNombreEmpleado(employeeEntity.getNombreEmpleado());
        existingEmployee.setNifEmpleado(employeeEntity.getNifEmpleado());
        existingEmployee.setEmail(employeeEntity.getEmail());
        existingEmployee.setPasswordEmpleado(employeeEntity.getPasswordEmpleado());
        if (employeeEntity.getRoles() != null && !employeeEntity.getRoles().isEmpty()) {
            existingEmployee.setRoles(employeeEntity.getRoles());
        }
        existingEmployee.setBeneficioEmpleado(employeeEntity.getBeneficioEmpleado());
        existingEmployee.setHoraEntrada(employeeEntity.getHoraEntrada());
        existingEmployee.setHoraSalida(employeeEntity.getHoraSalida());
        existingEmployee.setSalario(employeeEntity.getSalario());
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public EmployeeEntity findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
