package edu.yavirac.erp.facturacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.yavirac.erp.facturacion.entity.Cliente;
import edu.yavirac.erp.facturacion.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> findAll()
    {
        return clienteRepository.findAll();
    }

    //Read
    public Cliente findById(Long id)
    {
        return clienteRepository.findById(id).get();
    }

    //Create, Update
    public Cliente save(Cliente cliente)
    {
        return clienteRepository.save(cliente);
    }

    //Delete
    public void deleteById(long id)
    {
        clienteRepository.deleteById(id);
    }
}
