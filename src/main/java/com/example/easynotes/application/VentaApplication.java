package com.example.easynotes.application;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.easynotes.model.Venta;
import com.example.easynotes.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.easynotes.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class VentaApplication {
    @Autowired
    VentaRepository VentaRepository;
    
    public List<Venta> getAllVenta() {
        return VentaRepository.findAll();
    }

	public Venta guardarConfiguracion(@Valid Venta venta) throws Exception {
        if (venta == null) {
            throw new Exception("CLIENTE NO DEBE SER NULL");
        }

        if (!(venta.getfecha() == null)) {
            if (!(venta.getnombre() == null)) {
                if (!(venta.gettotal() == null)) {
                    return VentaRepository.save(venta);
                } else {
                    throw new Exception("falta campo PlazoMaximo");
                }
            } else {
                throw new Exception("falta campo Engache");
            }
        } else {
            throw new Exception("falta campo Tazafin");
        }
	}

}