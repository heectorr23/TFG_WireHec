package com.wirehec.microservice_Customer.Service.Impl;

import com.wirehec.microservice_Customer.Entity.CustomerEntity;
import com.wirehec.microservice_Customer.Repository.CustomerRepository;
import com.wirehec.microservice_Customer.Service.Inter.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerEntity> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerEntity saveCustomer(CustomerEntity customerEntity) {
        return customerRepository.save(customerEntity);
    }

    @Override
    public CustomerEntity updateCustomer(Long id, CustomerEntity customerEntity) {
        CustomerEntity existingCustomer = customerRepository.findById(id).orElseThrow();
        existingCustomer.setName(customerEntity.getName());
        existingCustomer.setContacto(customerEntity.getContacto());
        existingCustomer.setTelefono(customerEntity.getTelefono());
        existingCustomer.setIdentificacion(customerEntity.getIdentificacion());
        existingCustomer.setEmail(customerEntity.getEmail());
        existingCustomer.setZona(customerEntity.getZona());
        existingCustomer.setDireccion(customerEntity.getDireccion());
        return customerRepository.save(existingCustomer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
