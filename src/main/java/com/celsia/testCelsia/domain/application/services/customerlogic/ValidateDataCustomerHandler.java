package com.celsia.testCelsia.domain.application.services.customerlogic;

import com.celsia.testCelsia.domain.entities.Customer;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class ValidateDataCustomerHandler {
    ValidateDataCustomerHandler next;
    abstract boolean checkToCreateUser(Customer customer, List<String> lstErrors);
    protected boolean checkAndNextStep(Customer customer, List<String> lstErrors) {

        if(next == null){
            return true;
        }

        return next.checkToCreateUser(customer,lstErrors);
    }

    static ValidateDataCustomerHandler chain(ValidateDataCustomerHandler first,
                                             ValidateDataCustomerHandler... chain){

        ValidateDataCustomerHandler prompter = first;

        for(ValidateDataCustomerHandler nextStepInChain : chain){
            prompter.next = nextStepInChain;
            prompter = nextStepInChain;
        }

        return first;
    }
}

