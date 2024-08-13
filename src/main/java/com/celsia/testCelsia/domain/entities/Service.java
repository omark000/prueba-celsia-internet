package com.celsia.testCelsia.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@Table(name ="servicios")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String servicio;
    private Date fechainicio;
    private Date ultimafacturacion;
    private int ultimopago;
    @ManyToOne
    @JoinColumn(name = "identificacion")
    private Customer customer;
}
