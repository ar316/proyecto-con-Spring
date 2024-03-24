package com.estudiantes.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estudiantes.demo.Dao.IPersonaDao;
import com.estudiantes.demo.domain.Persona;

@Service
public class PersonaServiceImp implements PersonaService {

    @Autowired
    private IPersonaDao PersonaDao;



    @Override
    @Transactional(readOnly = true)
    public List<Persona> listaPersonas() {
      
        return (List<Persona>) PersonaDao.findAll();
    }

    @Override
    @Transactional
    public void Guardar(Persona p) {
        PersonaDao.save(p);
    }

    @Override
    @Transactional
    public void Eliminar(Persona p) {
        
        PersonaDao.delete(p);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona p) { 
        return PersonaDao.findById(p.getId()).orElse(null);
    }

    @Override
    public Persona findByid(Long id ){
        return PersonaDao.findById(id).orElse(null);
    }
    
}
