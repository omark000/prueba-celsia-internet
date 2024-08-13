package com.celsia.testCelsia.domain.application.services;

import com.celsia.testCelsia.domain.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements HandlerService{
    @Override
    public List<HandlerService> findAllServices() {
        return null;
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
