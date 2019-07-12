package com.example.easynotes.application;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.easynotes.model.Articulo;
import com.example.easynotes.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.easynotes.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class ArticuloApplication {
    @Autowired
    ArticuloRepository ArticuloRepository;

	public List<Articulo> articuloAll() {
        return ArticuloRepository.findAll();
	}

	public Articulo saveArticulo(@Valid Articulo Articulo) throws Exception {
        if (Articulo == null) {
            throw new Exception("CLIENTE NO DEBE SER NULL");
        }

        if (!(Articulo.getdescripcion() == null)) {
            if (!(Articulo.getmodelo() == null)) {
                if (!(Articulo.getprecio() == null)) {
                    if (!(Articulo.getexistencia() == null)) {
                        return ArticuloRepository.save(Articulo);
                    } else {
                        throw new Exception("falta campo existencia");
                    }
                } else {
                    throw new Exception("falta campo precio");
                }
            } else {
                throw new Exception("falta campo modelo");
            }
        } else {
            throw new Exception("falta campo descripcion");
        }
	}

    public Optional<Articulo> getIdArticulo(Long Articulo) throws Exception {
		return ArticuloRepository.findById(Articulo);
    }

	public long clienteArticulo() {
		return ArticuloRepository.count();
	}
    
    public Articulo updateCliente(Long articulo) throws Exception {
        return ArticuloRepository.findById(articulo).orElseThrow(() -> new ResourceNotFoundException("articulo", "id", articulo));
    }

	public Articulo saveCliente(Articulo articulo) {
		return ArticuloRepository.save(articulo);
	}

}