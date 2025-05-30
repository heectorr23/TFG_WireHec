package com.wirehec.microservice_Customer.Service.Inter;

import com.wirehec.microservice_Customer.Entity.CustomerEntity;

import java.util.List;

public interface ICustomerService {

    List<CustomerEntity> findAll();

    CustomerEntity saveCustomer(CustomerEntity CustomerEntity);

    CustomerEntity updateCustomer(Long id, CustomerEntity customerEntity);

    void deleteCustomer(Long id);
}
