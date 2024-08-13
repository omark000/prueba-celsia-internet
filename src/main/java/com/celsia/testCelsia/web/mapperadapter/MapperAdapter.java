package com.celsia.testCelsia.web.mapperadapter;

import com.celsia.testCelsia.domain.entities.Customer;
import com.celsia.testCelsia.web.dto.CustomerDto;

import java.util.List;

public interface MapperAdapter {

    Object convertClassToDto(Customer entitySource, Class dtoTarget);
    Object convertDtoToClass(CustomerDto dtoSource, Class dtoTarget);
    List<CustomerDto> convertClassListToDto(List<Customer> lstCustomer);
}
