package com.celsia.testCelsia.web.mapperadapter;

import com.celsia.testCelsia.domain.entities.ServiceCustomer;
import com.celsia.testCelsia.web.dto.ServiceDto;

import java.util.List;

public interface MapperServiceAdapter {
    Object convertClassToDto(ServiceCustomer entitySource, Class dtoTarget);
    Object convertDtoToClass(ServiceDto dtoSource, Class dtoTarget);
    List<ServiceDto> convertClassListToDto(List<ServiceCustomer> lstCustomer);

}
