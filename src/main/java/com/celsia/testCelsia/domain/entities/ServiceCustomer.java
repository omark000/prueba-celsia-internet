package com.celsia.testCelsia.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="servicios")
@IdClass(ServicioId.class)
public class ServiceCustomer {

    @Id
    @Column(name = "identificacion", length = 20, nullable = false)
    private String identificacion;

    @Id
    @Column(name = "servicio", length = 80, nullable = false)
    private String servicio;

    @Column(name = "fechainicio", nullable = false)
    private Date fechainicio;

    @Column(name = "ultimafacturacion", nullable = false)
    private Date ultimafacturacion;

    @Column(name = "ultimopago", nullable = false)
    private Integer ultimopago;

    @ManyToOne
    @JoinColumn(name = "identificacion", insertable = false, updatable = false)
    private Customer customer;

}
