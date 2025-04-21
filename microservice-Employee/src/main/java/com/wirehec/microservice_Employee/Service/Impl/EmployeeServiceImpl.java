package com.wirehec.microservice_Employee.Service.Impl;

import com.wirehec.microservice_Employee.Repository.EmployeeRepository;
import com.wirehec.microservice_Employee.Service.Inter.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
}
