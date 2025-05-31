package com.wirehec.microservice_Supplier.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "DetalleProveedor")
@EqualsAndHashCode
@ToString
public class SupplierDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdDetalleProveedor")
    private Long idDetalleProveedor;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "IdProveedor", referencedColumnName = "IdProveedor")
    private SupplierEntity supplierEntity;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "IdDetalleProveedor", referencedColumnName = "IdDetalleProveedor")
    private Set<SupplierOrderEntity> supplierOrderEntities;

    private Long idProduct;
}