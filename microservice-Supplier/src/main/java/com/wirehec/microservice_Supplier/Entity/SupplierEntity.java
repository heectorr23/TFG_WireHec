package com.wirehec.microservice_Supplier.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Proveedor")
@EqualsAndHashCode
@ToString
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdProveedor")
    private Long idProveedor;


    @Column(name = "nombreproveedor")
    private String nombreProveedor;

    @Column(name = "cifproveedor")
    private int cifProveedor;

    @Email
    @Column(name = "emailproveedor")
    private String emailProveedor;

    @Column(name = "categoriaproveedor")
    private String categoriaProveedor;

    @Column(name = "productoproveedor")
    private String productoProveedor;
}
