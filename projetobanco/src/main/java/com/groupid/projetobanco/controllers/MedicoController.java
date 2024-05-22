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

import com.groupid.projetobanco.models.Medico;
import com.groupid.projetobanco.repository.MedicoRepository;

@RestController
@RequestMapping("/funcionario/medico")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public String createMedico(@RequestBody Medico medico) {
        boolean inserted = medicoRepository.insertMedico(medico);
    
        if (inserted) {
            return "Médico inserido!\n";
        } 
        
        else {
            return "Já existe um médico com essa matrícula.\n";
        }
    }
    
    @DeleteMapping("/{matricula_medico}")
    public String deleteMedico(@PathVariable int matricula_medico) {
        boolean deleted = medicoRepository.deleteMedico(matricula_medico);
        if (deleted) {
            return "Médico deletado!\n";
        } else {
            return "O Médico com essa matrícula não existe no banco de dados!\n";
        }
    }

    @GetMapping("/allmedicos")
    public List<Medico> getMedicos(){
        return medicoRepository.getAllMedicos();
    }
}
