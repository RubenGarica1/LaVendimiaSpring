package com.example.easynotes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@Entity
@Table(name = "Configuracion")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Configuracion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String tazafin;

    @NotBlank
    private String engache; 
    
    @NotBlank
    private String plazoMaximo;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTazafin() {
        return tazafin;
    }

    public void setTazafin(String tazafin) {
        this.tazafin = tazafin;
    }

    public String getEngache() {
        return engache;
    }

    public void setEngache(String engache) {
        this.engache = engache;
    }

    public String getPlazoMaximo() {
        return plazoMaximo;
    }

    public void setPlazoMaximo(String plazoMaximo) {
        this.plazoMaximo = plazoMaximo;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}
