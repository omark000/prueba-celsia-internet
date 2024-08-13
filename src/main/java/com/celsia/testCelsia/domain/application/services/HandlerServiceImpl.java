package com.celsia.testCelsia.domain.application.services;

import com.celsia.testCelsia.domain.entities.Customer;
import com.celsia.testCelsia.domain.entities.ServiceCustomer;
import com.celsia.testCelsia.infrastructure.CustomerRepository;
import com.celsia.testCelsia.infrastructure.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class HandlerServiceImpl implements HandlerService{

    private final ServicesRepository servicesRepository;

    @Autowired
    public HandlerServiceImpl(ServicesRepository servicesRepository) {
        this.servicesRepository = servicesRepository;
    }


    @Override
    public List<ServiceCustomer> findAllServices() {
        return (List<ServiceCustomer>) servicesRepository.findAll();
    }

    @Override
    public String saveService(HandlerService service) {
        return null;
    }

    @Override
    public void deleteServiceId(String identification) {

    }

    @Override
    public Customer updateService(String identification, HandlerService service) {
        return null;
    }

    @Override
    public Customer findByIdentification(String identification) {
        return null;
    }
}
