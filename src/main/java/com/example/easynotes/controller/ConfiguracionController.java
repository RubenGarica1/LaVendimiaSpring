package com.example.easynotes.controller;

import com.example.easynotes.model.Configuracion;
import com.example.easynotes.repository.ConfiguracionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.application.ConfiguracionApplication;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@RestController
@RequestMapping("/app")
public class ConfiguracionController {

    @Autowired
    ConfiguracionApplication ConfiguracionApplication;

    @GetMapping("/configuracion")
    @CrossOrigin
    @PutMapping("/cors-enabled-endpoint")

    public List<Configuracion> getAllNotes() {
        return ConfiguracionApplication.getAllConfiguracion();
    }

    @PostMapping("/configuracion")
    @CrossOrigin
    @PutMapping("/cors-enabled-endpoint")
    public Configuracion createVenta(@Valid @RequestBody Configuracion Configuracion) throws Exception {
        return ConfiguracionApplication.guardarConfiguracion(Configuracion);
    }

    @PutMapping("/configuracion/{id}")
    @CrossOrigin
    public Configuracion updateNote(@PathVariable(value = "id") Long ConfiguracionId,
    @Valid @RequestBody Configuracion ClienteDetails) throws Exception {

        Configuracion Configuracion = ConfiguracionApplication.updateConfiguracion(ConfiguracionId);

        Configuracion.setTazafin(ClienteDetails.getTazafin());
        Configuracion.setEngache(ClienteDetails.getEngache());
        Configuracion.setPlazoMaximo(ClienteDetails.getPlazoMaximo());

        Configuracion updatedCliente = ConfiguracionApplication.saveConfiguracion(Configuracion);
        return updatedCliente;
    }

}
