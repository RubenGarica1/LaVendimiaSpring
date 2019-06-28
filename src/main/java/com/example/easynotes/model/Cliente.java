package com.example.easynotes.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@Entity
@Table(name = "cliente")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Autowired
    private String nombre;

    @Autowired
    private String appaterno;

    @Autowired
    private String apmaterno;

    @Autowired
    private String rfc;

    public Long getid() {
        return id;
    }

    public void setid(Long id) {
        this.id = id;
    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getappaterno() {
        return appaterno;
    }
    
    public void setappaterno(String appaterno) {
        this.appaterno = appaterno;
    }

    public String getapmaterno() {
        return apmaterno;
    }
    
    public void setapmaterno(String apmaterno) {
        this.apmaterno = apmaterno;
    }

    public String getrfc() {
        return rfc;
    }

    public void setrfc(String rfc) {
        this.rfc = rfc;
    }
}
