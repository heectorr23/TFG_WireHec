package com.wirehec.microservice_Contability.Controller;

import com.wirehec.microservice_Contability.Repository.ContabilityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contability")
@Slf4j
public class ContabilityController {

    @Autowired
    private ContabilityRepository contabilityRepository;
}
