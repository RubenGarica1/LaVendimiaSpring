package com.example.easynotes.controller;

import com.example.easynotes.model.Venta;
import com.example.easynotes.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@RestController
@RequestMapping("/app")
public class VentaController {

    @Autowired
    VentaRepository VentaRepository;

    @GetMapping("/venta")
    public List<Venta> getAllNotes() {
        return VentaRepository.findAll();
    }

    @PostMapping("/venta")
    public Venta createVenta(@Valid @RequestBody Venta venta) {
        System.out.println(venta);
        return VentaRepository.save(venta);
    }
}
