package com.estudiantes.demo.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.estudiantes.demo.Persona;

@Repository
public interface IPersonaDao extends CrudRepository<Persona, Long> {

    
    
} 