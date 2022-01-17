package edu.yavirac.erp.facturacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.yavirac.erp.facturacion.entity.Cliente;
import edu.yavirac.erp.facturacion.service.ClienteService;

@RestController
@RequestMapping("/cliente")
@CrossOrigin({"http://localhost:4200"})
public class ClienteController {
    
    @Autowired
    ClienteService clienteService;

    @GetMapping({"/lista","","/"})
    public List<Cliente> findAll()
    {
        return clienteService.findAll();
    }

    //Read
    @GetMapping("/{id}")
    public Cliente findById(@PathVariable long id)
    {
        return clienteService.findById(id);
    }

    //Create
    @PostMapping("/save")
    public Cliente save(@RequestBody Cliente cliente)
    {
        return clienteService.save(cliente);
    }

    //Update
    @PutMapping("/update")
    public Cliente update(@RequestBody Cliente cliente)
    {
        return clienteService.save(cliente);
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id)
    {
        clienteService.deleteById(id);
    }

}
