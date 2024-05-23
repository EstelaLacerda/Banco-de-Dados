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

import com.groupid.projetobanco.models.Recebe;
import com.groupid.projetobanco.repository.RecebeRepository;

@RestController
@RequestMapping("/funcionario/recebe/receita")
public class RecebeController {

    @Autowired
    private RecebeRepository recebeRepository;
    
    @PostMapping
    public String createRecebe(@RequestBody Recebe recebe) {
        recebeRepository.insertRecebe(recebe);
        return "Receita recebida pelo Funcionário!\n";
    }
    
    @DeleteMapping("/{id_receita}")
    public String deleteRecebe(@PathVariable int id_receita) {
        boolean deleted = recebeRepository.deleteRecebe(id_receita);
        
        if (deleted) {
            return "Receita retirada do Funcionário!\n";
        } 
        
        else {
            return "A receita com esse id não está contida nesse Funcionário especificado no banco de dados!\n";
        }
    }

    @GetMapping("/allrecebe")
    public List<Recebe> getRecebe(){
        return recebeRepository.getAllRecebe();
    }
}