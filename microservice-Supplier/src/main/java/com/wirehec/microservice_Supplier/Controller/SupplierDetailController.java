package com.wirehec.microservice_Supplier.Controller;

import com.wirehec.microservice_Supplier.Controller.DTO.SupplierDTO;
import com.wirehec.microservice_Supplier.Controller.DTO.SupplierDetailDTO;
import com.wirehec.microservice_Supplier.Entity.SupplierDetailEntity;
import com.wirehec.microservice_Supplier.Service.Impl.SupplierDetailServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplierDetail")
@Slf4j
public class SupplierDetailController {

    @Autowired
    private SupplierDetailServiceImpl supplierDetailService;

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        List<SupplierDetailDTO> supplierDetailDTOS = supplierDetailService.findAll()
                .stream()
                .map(supplierDetail -> SupplierDetailDTO.builder()
                        .idDetalleProveedor(supplierDetail.getIdDetalleProveedor())
                        .supplierEntity(supplierDetail.getSupplierEntity())
                        .supplierOrderEntities(supplierDetail.getSupplierOrderEntities())
                        .build()
                )
                .toList(); // Collect the stream into a list
        return ResponseEntity.ok(supplierDetailDTOS);
    }



    @PostMapping("/save")
    public ResponseEntity<?> saveSupplierDetail(@RequestBody SupplierDetailDTO supplierDetailDTO) {
        SupplierDetailEntity supplierDetailEntity = SupplierDetailEntity.builder()
                .idDetalleProveedor(supplierDetailDTO.getIdDetalleProveedor())
                .supplierEntity(supplierDetailDTO.getSupplierEntity())
                .supplierOrderEntities(supplierDetailDTO.getSupplierOrderEntities())
                .build();
        SupplierDetailEntity savedSupplierDetail = supplierDetailService.saveSupplierDetail(supplierDetailEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSupplierDetail);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateSupplierDetail(@PathVariable Long id, @RequestBody SupplierDetailDTO supplierDetailDTO) {
        SupplierDetailEntity supplierDetailEntity = SupplierDetailEntity.builder()
                .idDetalleProveedor(id)
                .supplierEntity(supplierDetailDTO.getSupplierEntity())
                .supplierOrderEntities(supplierDetailDTO.getSupplierOrderEntities())
                .build();
        SupplierDetailEntity updatedSupplierDetail = supplierDetailService.saveSupplierDetail(supplierDetailEntity);
        return ResponseEntity.ok(updatedSupplierDetail);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSupplierDetail(@PathVariable Long id) {
        supplierDetailService.deleteSupplierDetail(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
