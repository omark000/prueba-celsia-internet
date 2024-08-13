package com.celsia.testCelsia.web.dto;

import com.celsia.testCelsia.domain.entities.Customer;
import lombok.Data;


import java.util.Date;

@Data
public class ServiceDto {

    private String identificacion;
    private String servicio;
    private Date fechainicio;
    private Date ultimafacturacion;
    private Integer ultimopago;
}
