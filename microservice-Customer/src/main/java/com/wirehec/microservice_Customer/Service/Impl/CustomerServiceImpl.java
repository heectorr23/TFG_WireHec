package com.wirehec.microservice_Customer.Service.Impl;

import com.netflix.discovery.converters.Auto;
import com.wirehec.microservice_Customer.Repository.CustomerRepository;
import com.wirehec.microservice_Customer.Service.Inter.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

}
