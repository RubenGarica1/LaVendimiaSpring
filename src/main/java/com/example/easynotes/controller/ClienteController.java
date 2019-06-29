package com.example.easynotes.controller;

import com.example.easynotes.model.Cliente;
import com.example.easynotes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
