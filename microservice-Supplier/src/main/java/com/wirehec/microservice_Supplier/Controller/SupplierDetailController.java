package com.wirehec.microservice_Supplier.Controller;

import com.wirehec.microservice_Supplier.Controller.DTO.SuplierDetailDTO;
import com.wirehec.microservice_Supplier.Service.Impl.SupplierDetailServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/Detailsupplier")
@Slf4j
public class SupplierDetailController {

    @Autowired
    private SupplierDetailServiceImpl supplierDetailService;

    @GetMapping()
    @RequestMapping("/findAllSuplierProducts/{idProduct}")
    public ResponseEntity<?> findByIdProducts(@PathVariable Long idProduct) {

        List<SuplierDetailDTO> supplierDetailDTOs = supplierDetailService.findByIdProduct(idProduct)
                .stream()
                .map(supplierDetail -> SuplierDetailDTO.builder()
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
