package com.celsia.testCelsia.infrastructure;

import com.celsia.testCelsia.domain.entities.ServiceCustomer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServicesRepository extends CrudRepository<ServiceCustomer,Long> {

    Optional<ServiceCustomer> findByIdentificacion(String identification);
}
