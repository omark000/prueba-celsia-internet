package com.celsia.testCelsia.domain.application.services.customerlogic;

import com.celsia.testCelsia.domain.entities.Customer;
import com.celsia.testCelsia.infrastructure.CustomerRepository;

import java.util.List;

public class CheckIfUserExists extends ValidateDataCustomerHandler{

    private final CustomerRepository customerRepository;

    public CheckIfUserExists( CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    boolean checkToCreateUser(Customer customer, List<String> lstErrors) {
        if (checkIfUserExists(customer,lstErrors)){
            return checkAndNextStep(customer,lstErrors);
        }else {
            return false;
        }
    }

    boolean checkIfUserExists(Customer customer,List<String> lstErrors){
       Customer localCustomer = customerRepository.findByIdentificacion(customer.getIdentificacion()).orElse(new Customer());
       if(localCustomer.getIdentificacion() == null){
           return true;
       }
       else{
           lstErrors.add("El usuario ya existe");
           return  false;
       }
    }
}
