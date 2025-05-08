package com.wirehec.microservice_Supplier.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

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
    private Long  idPedidoProveedor;

    @Column(name = "fechaPedido")
    private Date fechaPedido;

    @Column(name = "fechaEntrega")
    private Date fechaEntrega;
}
