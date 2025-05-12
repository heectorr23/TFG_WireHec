package com.wirehec.microservice_Bill.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Factura")
@EqualsAndHashCode
@ToString
public class FacturaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdFactura")
    private Long id;

    @NotBlank
    private BigDecimal Precio;

    @NotBlank
    private String Zona;

    @NotBlank
    @Size(max = 100)
    private String Direccion;

}
