package com.example.easynotes.controller;
import com.example.easynotes.exception.ResourceNotFoundException;

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
    ArticuloRepository ArticuloRepository;

    @GetMapping("/articulo")
    @CrossOrigin
    @PutMapping("/cors-enabled-endpoint")
    public List<Articulo> getAllNotes() {
        return ArticuloRepository.findAll();
    }

    @PostMapping("/articulo")
    @CrossOrigin
    @PutMapping("/cors-enabled-endpoint")
    public Articulo createVenta(@Valid @RequestBody Articulo venta) {
        return ArticuloRepository.save(venta);
    }

    @GetMapping("/articulo/{id}")
    @CrossOrigin
    @PutMapping("/cors-enabled-endpoint")
    public Articulo getNoteById(@PathVariable(value = "id") Long id) {
        return ArticuloRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));
    }

    @PutMapping("/articulo/{id}")
    @CrossOrigin
    public Articulo updateNote(@PathVariable(value = "id") Long noteId,
                                           @Valid @RequestBody Articulo noteDetails) {

        Articulo articulo = ArticuloRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        articulo.setexistencia(noteDetails.getdescripcion());
        articulo.setexistencia(noteDetails.getexistencia());

        Articulo updatedNote = ArticuloRepository.save(articulo);
        return updatedNote;
    }
    @GetMapping("/articulo/count")
    @CrossOrigin
    @PutMapping("/cors-enabled-endpoint")

    public long countClientes() {
        return ArticuloRepository.count();
    }
}
