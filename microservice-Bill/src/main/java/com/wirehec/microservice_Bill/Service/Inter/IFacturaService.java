package com.wirehec.microservice_Bill.Service.Inter;

import com.wirehec.microservice_Bill.Entity.FacturaEntity;
import com.wirehec.microservice_Bill.HTTP.Response.CustomerByBillResponse;
import com.wirehec.microservice_Bill.HTTP.Response.EmployeeByBillResponse;

import java.util.List;

public interface IFacturaService {

    List<FacturaEntity> findAll();

    FacturaEntity saveFactura(FacturaEntity facturaEntity);

    FacturaEntity updateFactura(Long id, FacturaEntity facturaEntity);

    void deleteFactura(Long id);

    CustomerByBillResponse findCustomerByBill(Long idBill);

    EmployeeByBillResponse findEmployeeByBill(Long idBill);
}
