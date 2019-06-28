package com.example.easynotes.controller;

import com.example.easynotes.model.Articulo;
import com.example.easynotes.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@RestController
@RequestMapping("/app")
public class ArticuloController {

    @Autowired
    ArticuloRepository VentaRepository;

    @GetMapping("/articulo")
    public List<Articulo> getAllNotes() {
        return VentaRepository.findAll();
    }

    @PostMapping("/articulo")
    public Articulo createVenta(@Valid @RequestBody Articulo venta) {
        System.out.println(venta);
        return VentaRepository.save(venta);
    }
}
