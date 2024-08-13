package com.celsia.testCelsia.web.mapperadapter;

import com.celsia.testCelsia.domain.entities.Customer;
import com.celsia.testCelsia.web.dto.CustomerDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapperAdapterImpl implements MapperAdapter{

    ObjectMapper objectMapper = new ObjectMapper();

    public CustomerDto convertClassToDto(Customer customer){
        return objectMapper.convertValue(customer, CustomerDto.class);
    }
    public List<CustomerDto> convertClassListToDto(List<Customer> lstCustomer){
        return objectMapper.convertValue(lstCustomer, objectMapper.getTypeFactory()
                .constructCollectionType(List.class, CustomerDto.class));
    }
}
