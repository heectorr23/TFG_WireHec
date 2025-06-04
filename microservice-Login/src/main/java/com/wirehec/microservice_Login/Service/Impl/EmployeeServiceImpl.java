package com.wirehec.microservice_Login.Service.Impl;

import com.wirehec.microservice_Login.Repository.EmployeeRepository;
import com.wirehec.microservice_Login.Service.Inter.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean changePassword(String username, String newPassword) {
        return employeeRepository.findByUsername(username).map(employee -> {
            employee.setPasswordEmpleado(passwordEncoder.encode(newPassword)); // Encripta la nueva contraseña
            employeeRepository.save(employee);
            return true;
        }).orElse(false);
    }
}
