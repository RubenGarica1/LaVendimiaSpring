package com.example.easynotes.controller;

import com.example.easynotes.exception.ResourceNotFoundException;

import com.example.easynotes.model.Articulo;
import com.example.easynotes.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.easynotes.application.ArticuloApplication;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@RestController
@RequestMapping("/app")
public class ArticuloController {

    @Autowired
    ArticuloApplication ArticuloApplication;

    @GetMapping("/articulo")
    @CrossOrigin
    @PutMapping("/cors-enabled-endpoint")
    public List<Articulo> getAllArticulos() {
        return ArticuloApplication.articuloAll();
    }

    @PostMapping("/articulo")
    @CrossOrigin
    @PutMapping("/cors-enabled-endpoint")
    public Articulo createArticulo(@Valid @RequestBody Articulo Articulo) throws Exception {
        return ArticuloApplication.saveArticulo(Articulo);
    }

    @GetMapping("/articulo/{id}")
    @CrossOrigin
    @PutMapping("/cors-enabled-endpoint")
    public Optional<Articulo> getNoteById(@PathVariable(value = "id") Long Articulo) throws Exception {
        return ArticuloApplication.getIdArticulo(Articulo);
    }

    @GetMapping("/articulo/count")
    @CrossOrigin
    @PutMapping("/cors-enabled-endpoint")

    public long countClientes() throws Exception {
        return ArticuloApplication.clienteArticulo();
    }

    @PutMapping("/articulo/{id}")
    @CrossOrigin
    public Articulo updateArticulo(@PathVariable(value = "id") Long clienteId,
    @Valid @RequestBody Articulo ArticuloDetails) throws Exception {

        Articulo articulo = ArticuloApplication.updateCliente(clienteId);

        articulo.setnombre(ArticuloDetails.getdescripcion());
        articulo.setmodelo(ArticuloDetails.getmodelo());
        articulo.setprecio(ArticuloDetails.getprecio());
        articulo.setexistencia(ArticuloDetails.getexistencia());

        Articulo updatedCliente = ArticuloApplication.saveCliente(articulo);
        return updatedCliente;
    }

}