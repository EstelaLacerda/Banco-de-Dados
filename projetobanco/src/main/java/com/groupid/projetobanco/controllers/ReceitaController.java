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

import com.groupid.projetobanco.models.Receita;
import com.groupid.projetobanco.repository.ReceitaRepository;

@RestController
@RequestMapping("/receita")
public class ReceitaController {

    @Autowired
    private ReceitaRepository receitaRepository;

    @PostMapping
    public String createReceita(@RequestBody Receita receita){
        try{
            receitaRepository.insertReceita(receita);
            return "Receita inserido!\n";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao inserir receita: " + e.getMessage() + "\n";
        }
    }
    @DeleteMapping("/{id_receita}")
    public String deleteReceita(@PathVariable int id_receita){
        boolean deleted = receitaRepository.deleteReceita(id_receita);
        if(deleted){
            return "Receita deletada!\n";
        } else {
            return "A receita com essas informações não existe no banco de dados!\n";
        }
    }

    @GetMapping("/allreceitas")
    public List<Receita> getReceitas(){
        return receitaRepository.getAllReceitas();
    }
}
