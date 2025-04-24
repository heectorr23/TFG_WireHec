package com.wirehec.microservice_Login.Service.Impl;

import com.wirehec.microservice_Login.Repository.EmployeeRepository;
import com.wirehec.microservice_Login.Service.Inter.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeRepository loginrepository;
}
