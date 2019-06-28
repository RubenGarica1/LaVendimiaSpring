package com.example.easynotes.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@Entity
@Table(name = "venta")
@EntityListeners(AuditingEntityListener.class)

public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String folio;

    @NotBlank
    private String clavecliente;

    @NotBlank
    private String total;

    @NotBlank
    private String fecha;

    @NotBlank
    private String cantidadID;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfolio() {
        return folio;
    }

    public void setfolio(String folio) {
        this.folio = folio;
    }

    public String getclavecliente() {
        return clavecliente;
    }

    public void setclavecliente(String clavecliente) {
        this.clavecliente = clavecliente;
    }

    public String getTotal() {
        return total;
    }

    public void setfotal(String total) {
        this.total = total;
    }

    public String getfecha() {
        return fecha;
    }

    public void setfecha(String fecha) {
        this.fecha = fecha;
    }

    public String getcantidadID(){
        return cantidadID;
    }

    public void setcantidadID(String cantidadID) {
        this.cantidadID = cantidadID;
    }

}
