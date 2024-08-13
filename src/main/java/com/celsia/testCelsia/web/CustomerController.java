package com.celsia.testCelsia.web;


import com.celsia.testCelsia.domain.application.services.CustomerService;
import com.celsia.testCelsia.domain.entities.Customer;
import com.celsia.testCelsia.web.dto.CustomerDto;
import com.celsia.testCelsia.web.mapperadapter.MapperAdapterInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("CustomerController")
public class CustomerController {
    private final CustomerService customerService;
    private final MapperAdapterInterfaceService<CustomerDto, Customer> mapperDtoToCustomer;
    private final MapperAdapterInterfaceService<Customer, CustomerDto> mapperConvertListToDtoCustomer;


    @Autowired
    public CustomerController(CustomerService customerService, MapperAdapterInterfaceService<CustomerDto, Customer> mapperDtoToCustomer, MapperAdapterInterfaceService<Customer, CustomerDto> mapperConvertListToDtoCustomer) {
        this.customerService = customerService;
        this.mapperDtoToCustomer = mapperDtoToCustomer;
        this.mapperConvertListToDtoCustomer = mapperConvertListToDtoCustomer;
    }

    @GetMapping("/getAllWorkSpecifications")
    public List<CustomerDto> getAllCustomers() {
        List<Customer> lstCustomers = customerService.findAllCustomers();
        return mapperConvertListToDto(lstCustomers);
    }

    private Customer mapperDtoToWfcExternalSystem(CustomerDto dtoSource) {
        return mapperDtoToCustomer.mapperDtoToEntity(dtoSource, Customer.class);
    }

    private List<CustomerDto> mapperConvertListToDto(List<Customer> lstExternalSystems){
        return mapperConvertListToDtoCustomer.mapperConvertListToDtoList(lstExternalSystems, CustomerDto.class);
    }
}