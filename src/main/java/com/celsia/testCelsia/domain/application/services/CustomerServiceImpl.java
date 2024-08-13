package com.celsia.testCelsia.domain.application.services;

import com.celsia.testCelsia.domain.application.services.customerlogic.ClientCustomerSave;
import com.celsia.testCelsia.domain.entities.Customer;
import com.celsia.testCelsia.infrastructure.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public List<String> saveCustomer(Customer customer) {

        ClientCustomerSave clientCustomerSave = new ClientCustomerSave();
        List<String> lstErrors = clientCustomerSave.ExecuteSaveCustomer(customer, customerRepository);

        if(lstErrors.isEmpty()){
            customerRepository.save(customer);
            return new ArrayList<>();
        }
        log.error(lstErrors.toString());
        return lstErrors;
    }

    @Override
    public void deleteCustomerById(String identification) {
        customerRepository.deleteByIdentificacion(identification);
    }

    @Override
    public Customer updateCustomer(String identification, Customer customer) {
        return  customerRepository.findByIdentificacion(identification).
                map(loadCustomerSystem -> {
                    loadCustomerSystem.setApellidos(customer.getApellidos());
                    loadCustomerSystem.setNombres(customer.getNombres());
                    loadCustomerSystem.setIdentificacion(customer.getIdentificacion());
                    loadCustomerSystem.setNumerocelular(customer.getNumerocelular());
                    loadCustomerSystem.setFechanacimiento(customer.getFechanacimiento());
                    loadCustomerSystem.setCorreoelectronico(customer.getCorreoelectronico());
                    loadCustomerSystem.setTipoidentificacion(customer.getTipoidentificacion());

                    return customerRepository.save(loadCustomerSystem);
                }).orElse(new Customer());
    }

    @Override
    public Customer findByIdentification(String identification) {
        return customerRepository.findByIdentificacion(identification).orElse(new Customer());
    }
}
