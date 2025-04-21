package com.wirehec.microservice_Bill.Service.Impl;

import com.wirehec.microservice_Bill.Repository.FacturaRepository;
import com.wirehec.microservice_Bill.Service.Inter.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaServiceImpl implements IFacturaService {
    @Autowired
    private FacturaRepository facturaRepository;
}
