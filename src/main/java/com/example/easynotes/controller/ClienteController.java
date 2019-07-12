package com.example.easynotes.controller;

import com.example.easynotes.model.Cliente;
import com.example.easynotes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.application.ClienteApplication;
import com.example.easynotes.repository.ClienteRepository;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@RestController
@RequestMapping("/app")
public class ClienteController {
    @Autowired
    ClienteApplication ClienteApplication;

    @Autowired
    ClienteRepository ClienteRepository;

    @GetMapping("/cliente")
    @CrossOrigin
    @PutMapping("/cors-enabled-endpoint")
    public List<Cliente> getAllClientes() throws Exception {
        return ClienteApplication.getAllClientes();
    }

    @PostMapping("/cliente")
    @CrossOrigin
    @PutMapping("/cors-enabled-endpoint")
    public Cliente createVenta(@Valid @RequestBody Cliente venta) throws Exception {
        return ClienteApplication.guardaElCliente(venta);
    }

    @GetMapping("/cliente/{id}")
    @CrossOrigin
    @PutMapping("/cors-enabled-endpoint")
    public Optional<Cliente> getNoteById(@PathVariable(value = "id") Long cliente) throws Exception {
        return ClienteApplication.getIdClientes(cliente);
    }

    @GetMapping("/cliente/count")
    @CrossOrigin
    @PutMapping("/cors-enabled-endpoint")

    public long countClientes() throws Exception {
        return ClienteApplication.clienteCount();
    }

    @PutMapping("/cliente/{id}")
    @CrossOrigin
    public Cliente updateNote(@PathVariable(value = "id") Long clienteId,
    @Valid @RequestBody Cliente ClienteDetails) throws Exception {

        Cliente cliente = ClienteApplication.updateCliente(clienteId);

        cliente.setnombre(ClienteDetails.getnombre());
        cliente.setappaterno(ClienteDetails.getappaterno());
        cliente.setapmaterno(ClienteDetails.getapmaterno());
        cliente.setrfc(ClienteDetails.getrfc());

        Cliente updatedCliente = ClienteApplication.saveCliente(cliente);
        return updatedCliente;
    }

}
