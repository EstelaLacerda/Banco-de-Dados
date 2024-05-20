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

import com.groupid.projetobanco.models.Funcionario;
import com.groupid.projetobanco.repository.FuncionarioRepository;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @PostMapping
    public String createFuncionario(@RequestBody Funcionario funcionario){
        boolean inserted = funcionarioRepository.insertFuncionario(funcionario);
    
        if (inserted) {
            return "Funcionario inserido!\n";
        } 
        
        else {
            return "Já existe um funcionário com essa matrícula.\n";
        }
    }

    @DeleteMapping("/{matricula}")
    public String deleteFuncionario(@PathVariable int matricula){
        boolean deleted = funcionarioRepository.deleteFuncionario(matricula);
        if(deleted){
            return "Funcionario deletado!\n";
        } 
        
        else {
            return "O Funcionario com essas informações não existe no banco de dados!\n";
        }
    }

    @GetMapping
    public List<Funcionario> getFuncionario(){
        return funcionarioRepository.getAllFuncionarios();
    }
}
