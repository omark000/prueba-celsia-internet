package com.celsia.testCelsia.web.mapperadapter;

import com.celsia.testCelsia.domain.entities.Customer;
import com.celsia.testCelsia.web.dto.CustomerDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapperUserAdapterImpl implements MapperUserAdapter {

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Object convertClassToDto(Customer entitySource, Class dtoTarget){
        return objectMapper.convertValue(entitySource, dtoTarget);
    }

    @Override
    public Object convertDtoToClass(CustomerDto dtoSource, Class entityTarget) {
        return objectMapper.convertValue(dtoSource, entityTarget);
    }

    @Override
    public List<CustomerDto> convertClassListToDto(List<Customer> lstCustomer){
        return objectMapper.convertValue(lstCustomer, objectMapper.getTypeFactory()
                .constructCollectionType(List.class, CustomerDto.class));
    }
}
