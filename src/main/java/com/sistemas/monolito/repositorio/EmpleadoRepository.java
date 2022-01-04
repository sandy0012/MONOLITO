package com.sistemas.monolito.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemas.monolito.dominio.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{
    
}
