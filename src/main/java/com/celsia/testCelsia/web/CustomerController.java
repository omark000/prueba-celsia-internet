package com.celsia.testCelsia.web;


import com.celsia.testCelsia.domain.application.services.CustomerService;
import com.celsia.testCelsia.domain.entities.Customer;
import com.celsia.testCelsia.web.dto.CustomerDto;
import com.celsia.testCelsia.web.mapperadapter.MapperUserAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("CustomerController")
public class CustomerController {
    private final CustomerService customerService;
    private final MapperUserAdapter mapperUserAdapter;


    @Autowired
    public CustomerController(CustomerService customerService, MapperUserAdapter mapperUserAdapter) {
        this.customerService = customerService;
        this.mapperUserAdapter = mapperUserAdapter;
    }

    @GetMapping("/getAllCustomers")
    public List<CustomerDto> getAllCustomers() {
        List<Customer> lstCustomers = customerService.findAllCustomers();
        return mapperUserAdapter.convertClassListToDto(lstCustomers);
    }

    @GetMapping("/getCustomerById/{identification}")
    public CustomerDto getCustomerById(@PathVariable String identification) {
        Customer customer = customerService.findByIdentification(identification);
        return (CustomerDto) mapperUserAdapter.convertClassToDto(customer, CustomerDto.class);
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@RequestBody CustomerDto dto) {
        Customer customer = (Customer) mapperUserAdapter.convertDtoToClass(dto,Customer.class);
        return customerService.saveCustomer(customer);
    }

    @PutMapping("/updateCustomer/{identification}")
    public CustomerDto updateExternalSystem(@PathVariable String identification, @RequestBody CustomerDto dto){
        Customer customer = (Customer) mapperUserAdapter.convertDtoToClass(dto,Customer.class);
        Customer customerUpdate = customerService.updateCustomer(identification,customer);
        return (CustomerDto) mapperUserAdapter.convertClassToDto(customerUpdate, CustomerDto.class);
    }


}