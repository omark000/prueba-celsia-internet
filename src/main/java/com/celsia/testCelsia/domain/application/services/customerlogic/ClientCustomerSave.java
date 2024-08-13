package com.celsia.testCelsia.domain.application.services.customerlogic;

import com.celsia.testCelsia.domain.entities.Customer;
import com.celsia.testCelsia.infrastructure.CustomerRepository;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class ClientCustomerSave {


    public List<String> ExecuteSaveCustomer(Customer customer, CustomerRepository customerRepository){

        List<String> lstErrors = new ArrayList<>();

        ValidateDataCustomerHandler handler = ValidateDataCustomerHandler.
                                              chain(new CheckEmptyFieldsCustomer(),
                                                    new CheckIfUserExists(customerRepository));
       handler.checkToCreateUser(customer,lstErrors);

       return lstErrors;
    }

}
