package com.wirehec.microservice_Bill.Service.Impl;

import com.wirehec.microservice_Bill.Client.CustomerClient;
import com.wirehec.microservice_Bill.Client.EmployeeClient;
import com.wirehec.microservice_Bill.Controller.DTO.CustomerDTO;
import com.wirehec.microservice_Bill.Controller.DTO.EmployeeDTO;
import com.wirehec.microservice_Bill.Entity.FacturaEntity;
import com.wirehec.microservice_Bill.HTTP.Response.CustomerByBillResponse;
import com.wirehec.microservice_Bill.HTTP.Response.EmployeeByBillResponse;
import com.wirehec.microservice_Bill.Repository.FacturaRepository;
import com.wirehec.microservice_Bill.Service.Inter.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaServiceImpl implements IFacturaService {
    @Autowired
    private FacturaRepository facturaRepository;

    private CustomerClient customerClient;

    private EmployeeClient employeeClient;

    @Override
    public List<FacturaEntity> findAll() {
        return facturaRepository.findAll();
    }

    @Override
    public FacturaEntity saveFactura(FacturaEntity facturaEntity) {
        return facturaRepository.save(facturaEntity);
    }

    @Override
    public FacturaEntity updateFactura(Long id, FacturaEntity facturaEntity) {
        FacturaEntity existingFactura = facturaRepository.findById(id).orElseThrow();
        existingFactura.setId(facturaEntity.getId());
        existingFactura.setPrecio(facturaEntity.getPrecio());
        existingFactura.setZona(facturaEntity.getZona());
        existingFactura.setDireccion(facturaEntity.getDireccion());
        return facturaRepository.save(existingFactura);
    }

    @Override
    public void deleteFactura(Long id) {
        facturaRepository.deleteById(id);
    }

    @Override
    public CustomerByBillResponse findCustomerByBill(Long idBill) {
        FacturaEntity factura = facturaRepository.findById(idBill).orElseThrow();

        List<CustomerDTO> customerDTOList = customerClient.findByIdBills(idBill);

        return CustomerByBillResponse.builder()
                .id(factura.getId())
                .precio(factura.getPrecio())
                .zona(factura.getZona())
                .direccion(factura.getDireccion())
                .customers(customerDTOList)
                .build();
    }

    @Override
    public EmployeeByBillResponse findEmployeeByBill(Long idBill) {
        FacturaEntity factura = facturaRepository.findById(idBill).orElseThrow();
        List<EmployeeDTO> employeeDTOList = employeeClient.findByBills(idBill);

        return EmployeeByBillResponse.builder()
                .id(factura.getId())
                .precio(factura.getPrecio())
                .zona(factura.getZona())
                .direccion(factura.getDireccion())
                .employees(employeeDTOList)
                .build();
    }
}
