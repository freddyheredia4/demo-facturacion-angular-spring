package edu.yavirac.erp.facturacion.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.yavirac.erp.facturacion.entity.Cliente;

public interface ClienteRepository extends CrudRepository <Cliente, Long> {
    
    List<Cliente> findAll();
}
