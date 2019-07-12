package com.example.easynotes.application;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.easynotes.model.Configuracion;
import com.example.easynotes.repository.ConfiguracionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.easynotes.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class ConfiguracionApplication {
    @Autowired
    ConfiguracionRepository ConfiguracionRepository;

    public List<Configuracion> getAllConfiguracion() {
        return ConfiguracionRepository.findAll();
    }

    public Configuracion guardarConfiguracion(@Valid Configuracion Configuracion) throws Exception {
        if (Configuracion == null) {
            throw new Exception("CLIENTE NO DEBE SER NULL");
        }

        if (!(Configuracion.getTazafin() == null)) {
            if (!(Configuracion.getEngache() == null)) {
                if (!(Configuracion.getPlazoMaximo() == null)) {
                    return ConfiguracionRepository.save(Configuracion);
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

	public Configuracion updateConfiguracion(Long configuracionId) {
        return ConfiguracionRepository.findById(configuracionId).orElseThrow(() -> new ResourceNotFoundException("configuracionId", "id", configuracionId));
	}

	public Configuracion saveConfiguracion(Configuracion configuracion) {
		return ConfiguracionRepository.save(configuracion);
	}

}
