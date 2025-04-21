package com.wirehec.microservice_Bill.Controller;

import com.wirehec.microservice_Bill.Service.Impl.FacturaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/factura")
public class FacturaController {
    @Autowired
    private FacturaServiceImpl facturaService;
}
