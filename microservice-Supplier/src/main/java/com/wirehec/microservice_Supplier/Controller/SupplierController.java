package com.wirehec.microservice_Supplier.Controller;

import com.wirehec.microservice_Supplier.Controller.DTO.SupplierDTO;
import com.wirehec.microservice_Supplier.Entity.SupplierEntity;
import com.wirehec.microservice_Supplier.Service.Impl.SupplierServiceImpl;
import com.wirehec.microservice_Supplier.Service.Inter.ISupplierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
@Slf4j
public class SupplierController {

    @Autowired
    private SupplierServiceImpl supplierService;

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        List<SupplierDTO> supplierDTOs = supplierService.findAll()
                .stream()
                .map(supplier -> SupplierDTO.builder()
                        .idProveedor(supplier.getIdProveedor())
                        .nombreProveedor(supplier.getNombreProveedor())
                        .cifProveedor(supplier.getCifProveedor())
                        .emailProveedor(supplier.getEmailProveedor())
                        .categoriaProveedor(supplier.getCategoriaProveedor())
                        .productoProveedor(supplier.getProductoProveedor())
                        .build()
                )
                .toList(); // Collect the stream into a list
        return ResponseEntity.ok(supplierDTOs);
    }
    @PostMapping("/save")
    public ResponseEntity<?> saveSupplier(@RequestBody SupplierDTO supplierDTO) {
        SupplierEntity supplierEntity = SupplierEntity.builder()
                .nombreProveedor(supplierDTO.getNombreProveedor())
                .cifProveedor(supplierDTO.getCifProveedor())
                .emailProveedor(supplierDTO.getEmailProveedor())
                .categoriaProveedor(supplierDTO.getCategoriaProveedor())
                .productoProveedor(supplierDTO.getProductoProveedor())
                .build();
        SupplierEntity savedSupplier = supplierService.saveSupplier(supplierEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSupplier);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateSupplier(@PathVariable Long id, @RequestBody SupplierDTO supplierDTO) {
        SupplierEntity supplierEntity = SupplierEntity.builder()
                .idProveedor(id)
                .nombreProveedor(supplierDTO.getNombreProveedor())
                .cifProveedor(supplierDTO.getCifProveedor())
                .emailProveedor(supplierDTO.getEmailProveedor())
                .categoriaProveedor(supplierDTO.getCategoriaProveedor())
                .productoProveedor(supplierDTO.getProductoProveedor())
                .build();
        SupplierEntity updatedSupplier = supplierService.saveSupplier(supplierEntity);
        return ResponseEntity.ok(updatedSupplier);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
