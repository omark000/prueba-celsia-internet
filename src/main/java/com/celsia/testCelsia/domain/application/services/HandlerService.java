package com.celsia.testCelsia.domain.application.services;

import com.celsia.testCelsia.domain.entities.Customer;
import com.celsia.testCelsia.domain.entities.ServiceCustomer;

import java.util.List;

public interface HandlerService {
    List<ServiceCustomer> findAllServices();
    String saveService(HandlerService service);
    void deleteServiceId(String identification);
    Customer updateService(String identification, HandlerService service);
    Customer findByIdentification(String identification);
}
