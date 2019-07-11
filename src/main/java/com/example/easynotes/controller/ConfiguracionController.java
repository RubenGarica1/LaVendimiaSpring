package com.example.easynotes.controller;

import com.example.easynotes.model.Configuracion;
import com.example.easynotes.repository.ConfiguracionRepository;
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

    @PutMapping("/configuracion/{id}")
    @CrossOrigin
    public Configuracion updateNote(@PathVariable(value = "id") Long noteId,
    @Valid @RequestBody Configuracion ConfiguracionDetails) {

        Configuracion configuracion = ConfiguracionRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("configuracion", "id", noteId));

        configuracion.setTazafin(ConfiguracionDetails.getTazafin());
        configuracion.setEngache(ConfiguracionDetails.getEngache());
        configuracion.setPlazoMaximo(ConfiguracionDetails.getPlazoMaximo());

        Configuracion updatedNote = ConfiguracionRepository.save(configuracion);
        return updatedNote;
    }
}
