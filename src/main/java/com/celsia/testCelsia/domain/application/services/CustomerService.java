package com.celsia.testCelsia.domain.application.services;

import com.celsia.testCelsia.domain.entities.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAllCustomers();
    String saveCustomer(Customer customer);
    void deleteCustomerById(String identification);
    Customer updateCustomer(String identification, Customer customer);
    Customer findByIdentification(String identification);

}
