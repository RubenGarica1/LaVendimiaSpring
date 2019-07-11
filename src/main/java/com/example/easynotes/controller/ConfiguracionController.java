package com.example.easynotes.controller;

import com.example.easynotes.model.Configuracion;
import com.example.easynotes.repository.ConfiguracionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@RestController
@RequestMapping("/app")
public class ConfiguracionController {

    @Autowired
    ConfiguracionRepository ConfiguracionRepository;

    @GetMapping("/configuracion")
    @CrossOrigin
    @PutMapping("/cors-enabled-endpoint")

    public List<Configuracion> getAllNotes() {
        return ConfiguracionRepository.findAll();
    }

    @PostMapping("/configuracion")
    @CrossOrigin
    @PutMapping("/cors-enabled-endpoint")
    public Configuracion createVenta(@Valid @RequestBody Configuracion venta) {
        System.out.println(venta);
        return ConfiguracionRepository.save(venta);
    }
}
