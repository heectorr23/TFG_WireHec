package com.wirehec.microservice_Supplier.Controller;

import com.wirehec.microservice_Supplier.Controller.DTO.SupplierOrderDTO;
import com.wirehec.microservice_Supplier.Entity.SupplierOrderEntity;
import com.wirehec.microservice_Supplier.Service.Impl.SupplierOrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Ordersupplier")
@Slf4j
public class SupplierOrderController {

    @Autowired
    private SupplierOrderServiceImpl supplierOrderService;

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        List<SupplierOrderDTO> supplierOrderDTOS = supplierOrderService.findAll()
                .stream()
                .map(supplierOrder -> SupplierOrderDTO.builder()
                        .idPedidoProveedor(supplierOrder.getIdPedidoProveedor())
                        .build()
                )
                .toList(); // Collect the stream into a list
        return ResponseEntity.ok(supplierOrderDTOS);
    }
    @PostMapping("/save")
    public ResponseEntity<?> saveSupplierOrder(@RequestBody SupplierOrderDTO supplierOrderDTO) {
        SupplierOrderEntity supplierOrderEntity = SupplierOrderEntity.builder()
                .idPedidoProveedor(supplierOrderDTO.getIdPedidoProveedor())
                .build();
        SupplierOrderEntity savedSupplierOrder = supplierOrderService.saveSupplierOrder(supplierOrderEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSupplierOrder);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateSupplierOrder(@PathVariable Long id, @RequestBody SupplierOrderDTO supplierOrderDTO) {
        SupplierOrderEntity supplierOrderEntity = SupplierOrderEntity.builder()
                .idPedidoProveedor(id)
                .build();
        SupplierOrderEntity updatedSupplierOrder = supplierOrderService.saveSupplierOrder(supplierOrderEntity);
        return ResponseEntity.ok(updatedSupplierOrder);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSupplierOrder(@PathVariable Long id) {
        supplierOrderService.deleteSupplierOrder(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
