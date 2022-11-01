package com.sistema.asesoria.cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
    @Query( value = "SELECT * FROM cliente c WHERE c.correo_cliente = ?1 ", 
    nativeQuery = true)
    public Cliente findCorreo(String correo);
    
}
