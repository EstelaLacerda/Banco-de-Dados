package com.groupid.projetobanco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupid.projetobanco.models.Contem;
import com.groupid.projetobanco.repository.ContemRepository;

@RestController
@RequestMapping("/receita/contem/codigo_remedio")
public class ContemController {

    @Autowired
    private ContemRepository contemRepository;
    
    @PostMapping
    public String createContem(@RequestBody Contem contem) {
        contemRepository.insertContem(contem);
        return "Receita com Código do Remédio inserido!\n";
    }
    
    @DeleteMapping("/{codigo_remedio}")
    public String deleteContem(@PathVariable int codigo_remedio) {
        boolean deleted = contemRepository.deleteContem(codigo_remedio);
        
        if (deleted) {
            return "Medicamento deletado da receita!\n";
        } 
        
        else {
            return "O remédio com essa código não existe na receita especificada no banco de dados!\n";
        }
    }

    @GetMapping
    public List<Contem> getContem(){
        return contemRepository.getAllContem();
    }
}
