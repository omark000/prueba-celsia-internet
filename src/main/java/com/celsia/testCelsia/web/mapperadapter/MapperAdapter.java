package com.celsia.testCelsia.web.mapperadapter;

import com.celsia.testCelsia.domain.entities.Customer;
import com.celsia.testCelsia.web.dto.CustomerDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public interface MapperAdapter {

    public CustomerDto convertClassToDto(Customer customer);
    public List<CustomerDto> convertClassListToDto(List<Customer> lstCustomer);
}
