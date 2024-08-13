package com.celsia.testCelsia.infrastructure;

import com.celsia.testCelsia.domain.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {

    void deleteByIdentificacion(String identification);
    Optional<Customer> findByIdentificacion(String identification);
}
