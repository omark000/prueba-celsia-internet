package com.celsia.testCelsia.web.mapperadapter;

import com.celsia.testCelsia.domain.entities.ServiceCustomer;
import com.celsia.testCelsia.web.dto.CustomerDto;
import com.celsia.testCelsia.web.dto.ServiceDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapperServiceAdapterImpl implements MapperServiceAdapter{

    ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public Object convertClassToDto(ServiceCustomer entitySource, Class dtoTarget) {
        return objectMapper.convertValue(entitySource, dtoTarget);
    }

    @Override
    public Object convertDtoToClass(ServiceDto dtoSource, Class dtoTarget) {
        return objectMapper.convertValue(dtoSource, dtoTarget);
    }

    @Override
    public List<ServiceDto> convertClassListToDto(List<ServiceCustomer> lstService) {
        return objectMapper.convertValue(lstService, objectMapper.getTypeFactory()
                .constructCollectionType(List.class, CustomerDto.class));
    }
}
