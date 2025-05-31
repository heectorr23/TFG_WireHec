package com.wirehec.microservice_Supplier.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PedidoProveedor")
@EqualsAndHashCode
@ToString
public class SupplierOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPedidoProveedor")
    private Long idPedidoProveedor;

    @Column(name = "FechaPedido", nullable = false)
    private LocalDate FechaPedido;

    @Column(name = "FechaEntrega", nullable = false)
    private LocalDate FechaEntrega;
}