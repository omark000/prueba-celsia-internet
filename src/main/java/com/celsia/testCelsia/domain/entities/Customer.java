package com.celsia.testCelsia.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="clientes")
public class Customer {
    @Id
    @Column(name = "identificacion", nullable = false,length = 20)
    private String identificacion;
    @Column(name = "nombres", nullable = false, length = 80)
    private String nombres;
    @Column(name = "apellidos", nullable = false, length = 80)
    private String apellidos;
    @Column(name = "tipoidentificacion", nullable = false, length = 2)
    private String tipoidentificacion;
    @Column(name = "fechanacimiento", nullable = false)
    private Date fechanacimiento;
    @Column(name = "numerocelular", nullable = false, length = 20)
    private String numerocelular;
    @Column(name = "correoelectronico", nullable = false, length = 80)
    private String correoelectronico;

}
