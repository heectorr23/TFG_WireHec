package com.wirehec.microservice_Supplier.Controller;

import com.wirehec.microservice_Supplier.Service.Impl.SupplierDetailServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Detailsupplier")
@Slf4j
public class SupplierDetailController {

    @Autowired
    private SupplierDetailServiceImpl supplierDetailService;
}
