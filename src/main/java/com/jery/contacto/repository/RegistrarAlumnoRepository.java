package com.jery.contacto.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jery.contacto.entity.Alumno;

@Repository("registrarAlumnoRepository")
public interface RegistrarAlumnoRepository extends JpaRepository<Alumno, Serializable>{

    public abstract Alumno findById(int id);
    
}
