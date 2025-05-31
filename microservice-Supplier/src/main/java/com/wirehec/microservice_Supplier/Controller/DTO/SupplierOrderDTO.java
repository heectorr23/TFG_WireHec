package com.wirehec.microservice_Supplier.Controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SupplierOrderDTO {

    private Long idPedidoProveedor;

    private LocalDate FechaPedido;

    private LocalDate FechaEntrega;
}