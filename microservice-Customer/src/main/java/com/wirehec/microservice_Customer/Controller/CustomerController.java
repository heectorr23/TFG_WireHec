package com.wirehec.microservice_Customer.Controller;

import com.wirehec.microservice_Customer.Controller.DTO.CustomerDTO;
import com.wirehec.microservice_Customer.Entity.CustomerEntity;
import com.wirehec.microservice_Customer.Service.Impl.CustomerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @GetMapping("/all")
        public ResponseEntity<?> findAll() {
        List<CustomerDTO> customerDTOs = customerService.findAll()
                .stream()
                .map(customer -> CustomerDTO.builder()
                        .id(customer.getId())
                        .name(customer.getName())
                        .contacto(customer.getContacto())
                        .telefono(customer.getTelefono())
                        .identificacion(customer.getIdentificacion())
                        .email(customer.getEmail())
                        .zona(customer.getZona())
                        .direccion(customer.getDireccion())
                        .build()
                )
                .toList(); // Collect the stream into a list
        return ResponseEntity.ok(customerDTOs);
    }
    @PostMapping("/save")
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerEntity customerEntity = CustomerEntity.builder()
                .id(customerDTO.getId())
                .name(customerDTO.getName())
                .contacto(customerDTO.getContacto())
                .telefono(customerDTO.getTelefono())
                .identificacion(customerDTO.getIdentificacion())
                .email(customerDTO.getEmail())
                .zona(customerDTO.getZona())
                .direccion(customerDTO.getDireccion())
                .build();
        CustomerEntity savedCustomer = customerService.saveCustomer(customerEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        CustomerEntity customerEntity = CustomerEntity.builder()
                .id(id)
                .name(customerDTO.getName())
                .contacto(customerDTO.getContacto())
                .telefono(customerDTO.getTelefono())
                .identificacion(customerDTO.getIdentificacion())
                .email(customerDTO.getEmail())
                .zona(customerDTO.getZona())
                .direccion(customerDTO.getDireccion())
                .build();
        CustomerEntity updatedCustomer = customerService.saveCustomer(customerEntity);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
