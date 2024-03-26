package com.estudiantes.demo.servicios;

import java.util.List;


import com.estudiantes.demo.domain.Persona;

public interface PersonaService {
    
    //metodo que devuelve la lista de personas 
    public List<Persona> listaPersonas();

    public void Guardar(Persona p);

    public void Eliminar(Persona p);

    public Persona encontrarPersona(Persona p);

    public Persona findByid(Long id );

    

}
