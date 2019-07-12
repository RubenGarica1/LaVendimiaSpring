package com.example.easynotes.application;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.easynotes.model.Cliente;
import com.example.easynotes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.easynotes.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class ClienteApplication {
    @Autowired
    ClienteRepository VentaRepository;

    public Cliente guardaElCliente(Cliente cliente) throws Exception {
        if (cliente == null) {
            throw new Exception("CLIENTE NO DEBE SER NULL");
        }

        if (!(cliente.getnombre() == null)) {
            if (!(cliente.getapmaterno() == null)) {
                if (!(cliente.getappaterno() == null)) {
                    if (!(cliente.getrfc() == null)) {
                        return VentaRepository.save(cliente);
                    } else {
                        throw new Exception("falta campo rfc");
                    }
                } else {
                    throw new Exception("falta campo appaterno");
                }
            } else {
                throw new Exception("falta campo apmaterno");
            }
        } else {
            throw new Exception("falta campo nombre");
        }

    }

    public List<Cliente> getAllClientes() {
        return VentaRepository.findAll();
    }

    public Optional<Cliente> getIdClientes(Long cliente) throws Exception {
		return VentaRepository.findById(cliente);
    }
    
    public Cliente updateCliente(Long cliente) throws Exception {
        return VentaRepository.findById(cliente).orElseThrow(() -> new ResourceNotFoundException("cliente", "id", cliente));
    }
    
    public long clienteCount() throws Exception {
		return VentaRepository.count();
    }

	public Cliente saveCliente(Cliente cliente) {
		return VentaRepository.save(cliente);
	}
}
