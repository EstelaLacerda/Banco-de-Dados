package com.groupid.projetobanco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.groupid.projetobanco.models.Contem;
import com.groupid.projetobanco.repository.ContemRepository;

@RestController
@RequestMapping("/receita/contem")
public class ContemController {

    @Autowired
    private ContemRepository contemRepository;
    
    @PostMapping("/create")
    public String createContem(@RequestBody Contem contem) {
        contemRepository.insertContem(contem);
        return "Remédio adicionado à receita com sucesso!\n";
    }
    
    @DeleteMapping("/delete/{id_receita}/{codigo_remedio}")
    public String deleteContem(@PathVariable int id_receita, @PathVariable int codigo_remedio) {
        boolean deleted = contemRepository.deleteContem(id_receita, codigo_remedio);
        
        if (deleted) {
            return "Remédio removido da receita com sucesso!\n";
        } else {
            return "O remédio com esse código não existe na receita especificada no banco de dados!\n";
        }
    }

    @GetMapping("/all")
    public List<Contem> getContem(){
        return contemRepository.getAllContem();
    }
}
