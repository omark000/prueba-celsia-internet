package com.celsia.testCelsia.infrastructure;

import com.celsia.testCelsia.domain.entities.Service;
import org.springframework.data.repository.CrudRepository;

public interface ServicesRepository extends CrudRepository<Service,Long> {
}
