package com.test.test.repository;

import com.test.test.model.FacturaCabecera;
import org.springframework.data.repository.CrudRepository;

public interface FacturaRepository extends CrudRepository<FacturaCabecera, Long> {

}
