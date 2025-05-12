package com.wirehec.microservice_Bill.Controller;

import com.wirehec.microservice_Bill.Controller.DTO.FacturaDTO;
import com.wirehec.microservice_Bill.Entity.FacturaEntity;
import com.wirehec.microservice_Bill.Service.Impl.FacturaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bill")
public class FacturaController {
    @Autowired
    private FacturaServiceImpl facturaService;

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        List<FacturaDTO> facturaDTOS = facturaService.findAll()
                .stream()
                .map(factura -> FacturaDTO.builder()
                        .id(factura.getId())
                        .Precio(factura.getPrecio())
                        .Zona(factura.getZona())
                        .Direccion(factura.getDireccion())
                        .build()
                )
                .toList(); // Collect the stream into a list
        return ResponseEntity.ok(facturaDTOS);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveFactura(@RequestBody FacturaDTO facturaDTO) {
        FacturaEntity facturaEntity = FacturaEntity.builder()
                .id(facturaDTO.getId())
                .Precio(facturaDTO.getPrecio())
                .Zona(facturaDTO.getZona())
                .Direccion(facturaDTO.getDireccion())
                .build();
        FacturaEntity savedFactura = facturaService.saveFactura(facturaEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFactura);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateFactura(@PathVariable Long id, @RequestBody FacturaDTO facturaDTO) {
        FacturaEntity facturaEntity = FacturaEntity.builder()
                .id(facturaDTO.getId())
                .Precio(facturaDTO.getPrecio())
                .Zona(facturaDTO.getZona())
                .Direccion(facturaDTO.getDireccion())
                .build();
        FacturaEntity updatedFactura = facturaService.saveFactura(facturaEntity);
        return ResponseEntity.ok(updatedFactura);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFactura(@PathVariable Long id) {
        facturaService.deleteFactura(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/findCustomerByBill/{idCustomer}")
    public ResponseEntity<?> findCustomerByBill(@PathVariable Long idCustomer) {
        return ResponseEntity.ok(facturaService.findCustomerByBill(idCustomer));
    }

    @GetMapping("/findEmployeeByBill/{idEmployee}")
    public ResponseEntity<?> findEmployeeByBill(@PathVariable Long idEmployee) {
        return ResponseEntity.ok(facturaService.findEmployeeByBill(idEmployee));
    }

}
