package com.celsia.testCelsia.web;


import com.celsia.testCelsia.domain.application.services.CustomerService;
import com.celsia.testCelsia.domain.entities.Customer;
import com.celsia.testCelsia.web.dto.CustomerDto;
import com.celsia.testCelsia.web.mapperadapter.MapperAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("CustomerController")
public class CustomerController {
    private final CustomerService customerService;
    private final MapperAdapter mapperAdapter;


    @Autowired
    public CustomerController(CustomerService customerService,MapperAdapter mapperAdapter) {
        this.customerService = customerService;
        this.mapperAdapter = mapperAdapter;
    }

    @GetMapping("/getAllCustomers")
    public List<CustomerDto> getAllCustomers() {
        List<Customer> lstCustomers = customerService.findAllCustomers();
        return mapperAdapter.convertClassListToDto(lstCustomers);
    }

    @GetMapping("/getCustomerById/{identification}")
    public CustomerDto getCustomerById(@PathVariable String identification) {
        Customer customer = customerService.findByIdentification(identification);
        return mapperAdapter.convertClassToDto(customer);
    }


}