package com.example.easynotes.controller;

import com.example.easynotes.model.Venta;
import com.example.easynotes.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.easynotes.application.VentaApplication;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@RestController
@RequestMapping("/app")
public class VentaController {

    @Autowired
    VentaApplication VentaApplication;

    @GetMapping("/venta")
    @CrossOrigin
    @PutMapping("/cors-enabled-endpoint")

    public List<Venta> getAlVentas() {
        return VentaApplication.getAllVenta();
    }

    @PostMapping("/venta")
    @CrossOrigin
    @PutMapping("/cors-enabled-endpoint")
    public Venta createVenta(@Valid @RequestBody Venta Venta) throws Exception {
        return VentaApplication.guardarConfiguracion(Venta);
    }
}
