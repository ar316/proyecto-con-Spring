package com.estudiantes.demo.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.estudiantes.demo.Dao.IPersonaDao;



@Controller
public class Controlador {
    
    @Autowired
    private IPersonaDao personaDao; 
    @GetMapping("/incios")
    public String Inicio(Model model){
       var personas = personaDao.findAll();
        System.out.println("si entra al empoint");
        model.addAttribute("personas", personas);
        return "index.html";
    }
}
