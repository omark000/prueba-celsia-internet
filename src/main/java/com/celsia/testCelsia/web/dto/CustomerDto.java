package com.celsia.testCelsia.web.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CustomerDto {
    private String identificacion;
    private String nombres;
    private String apellidos;
    private String tipoidentificacion;
    private Date fechanacimiento;
    private String numerocelular;
    private String correoelectronico;
}
