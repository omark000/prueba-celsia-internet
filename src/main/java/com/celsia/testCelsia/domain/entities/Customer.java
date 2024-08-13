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
@Table(name ="clientes")
public class Customer {
    @Id
    @Column(name = "identificacion")
    private String identificacion;
    private String nombres;
    private String apellidos;
    private String tipoidentificacion;
    private Date fechanacimiento;
    private String numerocelular;

    private String correoelectronico;
}
