package com.example.easynotes.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@Entity
@Table(name = "articulo")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Autowired
    private String descripcion;

    @Autowired
    private String modelo;

    @Autowired
    private String precio;

    @Autowired
    private String existencia;

    public Long getid() {
        return id;
    }

    public void setid(Long id) {
        this.id = id;
    }

    public String getdescripcion() {
        return descripcion;
    }

    public void setnombre(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getappaterno() {
        return modelo;
    }
    
    public void setmodelo(String modelo) {
        this.modelo = modelo;
    }

    public String getprecio() {
        return precio;
    }
    
    public void setprecio(String precio) {
        this.precio = precio;
    }

    public String getexistencia() {
        return existencia;
    }

    public void setexistencia(String existencia) {
        this.existencia = existencia;
    }
}
