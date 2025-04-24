package com.wirehec.microservice_Login.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Empleado")
@EqualsAndHashCode
@ToString
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdEmpleado")
    private Long id;

    @Column(name="NombreEmpleado")
    private String nombreEmpleado;

    @Column(name="NifEmpleado")
    private String nifEmpleado;

    @Column(name="TelefonoEmpleado")
    private int telefonoEmpleado;

    @Email
    @Column(name="EmailEmpleado")
    private String email;

    @Column(name="PasswordEmpleado")
    private String passwordEmpleado;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = RoleEntity.class, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "id_empleado"),
            inverseJoinColumns = @JoinColumn(name = "id_rol"))
    private Set<RoleEntity> roles;

    @Column(name="BeneficioEmpleado")
    private int beneficioEmpleado;

    @Column(name="HoraEntrada")
    private LocalDateTime horaEntrada = LocalDateTime.now();

    @Column(name="HoraSalida")
    private LocalDateTime horaSalida = LocalDateTime.now();

    @Column(name="Salario")
    private BigDecimal salario;
}
