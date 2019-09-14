/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jery.contacto.repository;

import com.jery.contacto.entity.Profesores;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jery
 */
public interface ProfesorRepository  extends JpaRepository<Profesores, Serializable>{
    
}
