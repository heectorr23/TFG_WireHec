package com.wirehec.microservice_Customer.Entity;

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
@Table(name = "Cliente")
@EqualsAndHashCode
@ToString
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCliente")
    private Long id;

    @Column(name = "NombreCliente")
    private String name;

    @Column(name= "ContactoCliente")
    private String contacto;

    @Column(name= "TelefonoCliente")
    private int telefono;

    @Column(name= "IdentificacionCliente")
    private String identificacion;

    @Email
    @Column(name= "EmailCliente")
    private String email;

    @Column(name= "Zona")
    private String zona;

    @Column(name= "DireccionCliente")
    private String direccion;

}
