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

import com.groupid.projetobanco.models.Paciente;
import com.groupid.projetobanco.repository.PacienteRepository;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    
    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    public String createPaciente(@RequestBody Paciente paciente){
        try{
            pacienteRepository.insertPaciente(paciente);;
            return "Paciente inserido!\n";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao inserir paciente: " + e.getMessage() + "\n";
        }
    }
    @DeleteMapping("/{cpf}")
    public String deletePaciente(@PathVariable String cpf){
        boolean deleted = pacienteRepository.deletePaciente(cpf);
        if(deleted){
            return "Paciente deletada!\n";
        } else {
            return "A paciente com essas informações não existe no banco de dados!\n";
        }
    }

    @GetMapping
    public List<Paciente> getPacientes(){
        return pacienteRepository.getAllPacientes();
    }
}


