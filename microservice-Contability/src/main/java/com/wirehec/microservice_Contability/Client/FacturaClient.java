package com.wirehec.microservice_Contability.Client;

import com.wirehec.microservice_Contability.Controller.DTO.FacturaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-bill", url = "localhost:8082/api/bill")
@Component
public interface FacturaClient {

    @GetMapping("/findAllBillContability/{idBill}")
    List<FacturaDTO> findByIdContabilitys(@PathVariable Long idContabilidad);

}
