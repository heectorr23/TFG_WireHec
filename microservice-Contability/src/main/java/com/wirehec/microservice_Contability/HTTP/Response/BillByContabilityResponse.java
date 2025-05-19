package com.wirehec.microservice_Contability.HTTP.Response;

import com.wirehec.microservice_Contability.Controller.DTO.FacturaDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillByContabilityResponse {

    private Long idContabilidad;
    private Float presupuestomensual;
    private Float beneficio;
    private Float gasto;
    private List<FacturaDTO> facturas;
}
