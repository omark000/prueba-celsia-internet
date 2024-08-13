package com.celsia.testCelsia.domain.application.services.customerlogic;
import com.celsia.testCelsia.domain.entities.Customer;

import java.util.ArrayList;
import java.util.List;


public class CheckEmptyFieldsCustomer extends ValidateDataCustomerHandler{


    @Override
    boolean checkToCreateUser(Customer customer, List<String> lstErrors ) {
        boolean isSuccess = checkEmptyFields(customer,lstErrors);

        if(isSuccess){
            return checkAndNextStep(customer,lstErrors);
        }

        return isSuccess;
    }

    private boolean checkEmptyFields(Customer customer,List<String> lstErrors){

        if(isEmptyOrNull(customer.getApellidos())){
            lstErrors.add("Por favor cerciorarse que todos los apellidos estén diligenciados");
        }

        if(isEmptyOrNull(customer.getIdentificacion())){
            lstErrors.add("Por favor cerciorarse que la identificación esté diligenciada");
        }

        if(isEmptyOrNull(customer.getCorreoelectronico())){
            lstErrors.add("Por favor cerciorarse que el correo electrónico esté diligenciada");
        }

        if(isEmptyOrNull(customer.getNombres())){
            lstErrors.add("Por favor cerciorarse que el nombre esté diligenciada");
        }

        if(isEmptyOrNull(customer.getTipoidentificacion())){
            lstErrors.add("Por favor cerciorarse que el Tipo identificacion esté diligenciado");
        }

        if(isEmptyOrNull(customer.getNumerocelular())){
            lstErrors.add("Por favor cerciorarse que el Numero celular esté diligenciado");
        }

        if(customer.getFechanacimiento() == null){
            lstErrors.add("Por favor cerciorarse que la fecha esté diligenciada");
        }

        return lstErrors.isEmpty();
    }

    private boolean isEmptyOrNull(String fieldToValidate){
        return fieldToValidate == null || fieldToValidate.isEmpty();
    }


}
