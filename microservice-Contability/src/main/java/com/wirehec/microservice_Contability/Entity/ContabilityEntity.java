package com.wirehec.microservice_Contability.Entity;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Contabilidad")
@EqualsAndHashCode
@ToString
public class ContabilityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdContabilidad")
    private Long idContabilidad;

    @Column (name = "PresupuestoMensual")
    private Float presupuestomensual;

    @Column (name = "Beneficio")
    private Float beneficio;

    @Column (name= "Gasto")
    private Float gasto;

}
