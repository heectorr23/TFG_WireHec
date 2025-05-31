package com.wirehec.microservice_Supplier.Controller;

import com.wirehec.microservice_Supplier.Controller.DTO.SupplierDetailDTO;
import com.wirehec.microservice_Supplier.Entity.SupplierDetailEntity;
import com.wirehec.microservice_Supplier.Entity.SupplierOrderEntity;
import com.wirehec.microservice_Supplier.Service.Impl.SupplierDetailServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
        System.out.println("Solicitud recibida en /save con datos: " + supplierDetailDTO);

        SupplierDetailEntity supplierDetailEntity = SupplierDetailEntity.builder()
                .idDetalleProveedor(supplierDetailDTO.getIdDetalleProveedor())
                .supplierEntity(supplierDetailDTO.getSupplierEntity())
                .supplierOrderEntities(
                        supplierDetailDTO.getSupplierOrderEntities().stream()
                                .map(order -> SupplierOrderEntity.builder()
                                        .idPedidoProveedor(null) // Asegurarse de que sea nulo para que la DB lo genere
                                        .FechaPedido(order.getFechaPedido())
                                        .FechaEntrega(order.getFechaEntrega())
                                        .build()
                                ).collect(Collectors.toSet())
                )
                .idProduct(supplierDetailDTO.getIdProduct())
                .build();

        SupplierDetailEntity savedSupplierDetail = supplierDetailService.saveSupplierDetail(supplierDetailEntity);
        System.out.println("Detalle del proveedor guardado: " + savedSupplierDetail);

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

    @GetMapping()
    @RequestMapping("/findAllSuplierProducts/{idProduct}")
    public ResponseEntity<?> findByIdProducts(@PathVariable Long idProduct) {

        List<SupplierDetailDTO> supplierDetailDTOs = supplierDetailService.findByIdProduct(idProduct)
                .stream()
                .map(supplierDetail -> SupplierDetailDTO.builder()
                        .idDetalleProveedor(supplierDetail.getIdDetalleProveedor())
                        .supplierEntity(supplierDetail.getSupplierEntity())
                        .supplierOrderEntities(supplierDetail.getSupplierOrderEntities())
                        .idProduct(supplierDetail.getIdProduct())
                        .build()
                )
                .toList(); // Collect the stream into a list

        return ResponseEntity.ok(supplierDetailDTOs);
    }
}
