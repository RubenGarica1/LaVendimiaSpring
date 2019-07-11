package com.example.easynotes.controller;

import com.example.easynotes.model.Cliente;
import com.example.easynotes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.easynotes.exception.ResourceNotFoundException;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@RestController
@RequestMapping("/app")
public class ClienteController {

    @Autowired
    ClienteRepository VentaRepository;

    @GetMapping("/cliente")
    @CrossOrigin
    @PutMapping("/cors-enabled-endpoint")

    public List<Cliente> getAllNotes() {
        return VentaRepository.findAll();
    }

    @PostMapping("/cliente")
    @CrossOrigin
    @PutMapping("/cors-enabled-endpoint")
    public Cliente createVenta(@Valid @RequestBody Cliente venta) {
        System.out.println(venta);
        return VentaRepository.save(venta);
    }
    
    @GetMapping("/cliente/{id}")
    @CrossOrigin
    @PutMapping("/cors-enabled-endpoint")
    public Cliente getNoteById(@PathVariable(value = "id") Long cliente) {
        return VentaRepository.findById(cliente)
                .orElseThrow(() -> new ResourceNotFoundException("cliente", "id", cliente));
    }

    @GetMapping("/cliente/count")
    @CrossOrigin
    @PutMapping("/cors-enabled-endpoint")

    public long countClientes() {
        return VentaRepository.count();
    }

    @PutMapping("/cliente/{id}")
    @CrossOrigin
    public Cliente updateNote(@PathVariable(value = "id") Long clienteId,
    @Valid @RequestBody Cliente ClienteDetails) {

        Cliente cliente = VentaRepository.findById(clienteId)
                .orElseThrow(() -> new ResourceNotFoundException("cliente", "id", clienteId));

        cliente.setnombre(ClienteDetails.getnombre());
        cliente.setappaterno(ClienteDetails.getappaterno());
        cliente.setapmaterno(ClienteDetails.getapmaterno());
        cliente.setrfc(ClienteDetails.getrfc());

        Cliente updatedCliente = VentaRepository.save(cliente);
        return updatedCliente;
    }
}
