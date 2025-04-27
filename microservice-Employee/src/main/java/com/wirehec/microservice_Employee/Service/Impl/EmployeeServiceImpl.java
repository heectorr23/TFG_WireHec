package com.wirehec.microservice_Employee.Service.Impl;

import com.wirehec.microservice_Employee.Entity.EmployeeEntity;
import com.wirehec.microservice_Employee.Repository.EmployeeRepository;
import com.wirehec.microservice_Employee.Service.Inter.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeEntity> findAll() {
        return employeeRepository.findAll();
    }
    @Override
    public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    public EmployeeEntity updateEmployee(Long id, EmployeeEntity employeeEntity) {
        EmployeeEntity existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        existingEmployee.setNombreEmpleado(employeeEntity.getNombreEmpleado());
        existingEmployee.setNifEmpleado(employeeEntity.getNifEmpleado());
        existingEmployee.setEmail(employeeEntity.getEmail());
        existingEmployee.setPasswordEmpleado(employeeEntity.getPasswordEmpleado());
        existingEmployee.setRoles(employeeEntity.getRoles());
        existingEmployee.setBeneficioEmpleado(employeeEntity.getBeneficioEmpleado());
        existingEmployee.setHoraEntrada(employeeEntity.getHoraEntrada());
        existingEmployee.setHoraSalida(employeeEntity.getHoraSalida());
        existingEmployee.setSalario(employeeEntity.getSalario());
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }






}
