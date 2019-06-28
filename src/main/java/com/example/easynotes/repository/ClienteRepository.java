package com.example.easynotes.repository;

import com.example.easynotes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
