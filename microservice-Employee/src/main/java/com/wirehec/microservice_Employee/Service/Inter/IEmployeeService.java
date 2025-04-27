package com.wirehec.microservice_Employee.Service.Inter;


import com.wirehec.microservice_Employee.Entity.EmployeeEntity;

import java.util.List;

public interface IEmployeeService {

    List<EmployeeEntity> findAll();

    EmployeeEntity saveEmployee(EmployeeEntity employeeEntity);

    void deleteEmployee(Long id);
}
