package com.wirehec.microservice_LowStock.Controller;

import com.wirehec.microservice_LowStock.Service.Impl.LowStockServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lowstock")
@Slf4j
public class LowStockController {

    @Autowired
    private LowStockServiceImpl lowStockService;
}
