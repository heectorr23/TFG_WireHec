package com.wirehec.microservice_Login.Controller;


import com.wirehec.microservice_Login.Service.Impl.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Slf4j
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;

}
