/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Hp
 */
@Controller
public class PaginaPrin {
    @GetMapping
    public String mostrarPagina() {
      
        return "Basado"; 
    }
    @GetMapping("/tabla")
    public String mostrarPagina2() {
      
        return "tabla"; 
    }
}
