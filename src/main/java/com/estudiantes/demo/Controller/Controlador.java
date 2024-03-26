package com.estudiantes.demo.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;

import com.estudiantes.demo.domain.Persona;
import com.estudiantes.demo.servicios.PersonaService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class Controlador {
    
    @Autowired
    private PersonaService personaService; 
    @GetMapping("/incios")
    public String Inicio(Model model){
        System.out.println("si entra al endpoint");
        
        // Crear una nueva persona
     
        
        // Obtener la lista actualizada de personas
        var personas = personaService.listaPersonas();
        
        // Agregar la lista de personas al modelo
        model.addAttribute("personas", personas);
        
        // Devolver la vista index.html
        return "index";
    }

    @GetMapping("/agregar")
    public String Agregar(Persona persona){
        return "addCliente";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores) {
        if(errores.hasErrors()){
            System.out.println("ha ocurrido un errror");
            return "addCliente";  
        }
       personaService.Guardar(persona);
       return "redirect:/incios";
    }
    
    @GetMapping("/Editar")
    public String Editar(Persona p, Model model) {
         p  = personaService.encontrarPersona(p);
        model.addAttribute("persona", p);        
        return "addCliente";
    }

    @GetMapping("/Eliminar/{id}")
    public String Eliminar(Persona p){ 
        personaService.Eliminar(p);
        return "redirect:/incios";
    }

    
}
