package com.groupid.projetobanco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    
    @DeleteMapping("/{matricula_funcionario}/{id_receita}")
    public String deleteRecebe(@PathVariable int matricula_funcionario, @PathVariable int id_receita) {
        boolean deleted = recebeRepository.deleteRecebe(matricula_funcionario, id_receita);
        
        if (deleted) {
            return "Receita retirada do Funcionário!\n";
        } else {
            return "A receita com esse ID não está associada a esse funcionário especificado no banco de dados!\n";
        }
    }

    @GetMapping("/allrecebe")
    public List<Recebe> getRecebe(){
        return recebeRepository.getAllRecebe();
    }
}
