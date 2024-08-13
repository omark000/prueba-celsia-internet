package com.celsia.testCelsia.web;


import com.celsia.testCelsia.domain.application.services.HandlerService;
import com.celsia.testCelsia.domain.entities.ServiceCustomer;
import com.celsia.testCelsia.web.dto.ServiceDto;
import com.celsia.testCelsia.web.mapperadapter.MapperServiceAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ServiceController")
public class ServiceController {
    private final HandlerService handlerService;
    private final MapperServiceAdapter mapperServiceAdapter;


    @Autowired
    public ServiceController(HandlerService handlerService, MapperServiceAdapter mapperServiceAdapter) {
        this.handlerService = handlerService;
        this.mapperServiceAdapter = mapperServiceAdapter;
    }

    @GetMapping("/getAllServices")
    public List<ServiceCustomer> getAllServices() {
        return handlerService.findAllServices();
    }

    /*
    @GetMapping("/getCustomerById/{identification}")
    public CustomerDto getCustomerById(@PathVariable String identification) {
        Customer customer = customerService.findByIdentification(identification);
        return (CustomerDto) mapperAdapter.convertClassToDto(customer, CustomerDto.class);
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@RequestBody CustomerDto dto) {
        Customer customer = (Customer)mapperAdapter.convertDtoToClass(dto,Customer.class);
        return customerService.saveCustomer(customer);
    }

    @PutMapping("/updateCustomer/{identification}")
    public CustomerDto updateExternalSystem(@PathVariable String identification, @RequestBody CustomerDto dto){
        Customer customer = (Customer)mapperAdapter.convertDtoToClass(dto,Customer.class);
        Customer customerUpdate = customerService.updateCustomer(identification,customer);
        return (CustomerDto) mapperAdapter.convertClassToDto(customerUpdate, CustomerDto.class);
    }
*/

}