package com.groupid.projetobanco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.groupid.projetobanco.models.Medico;
import com.groupid.projetobanco.repository.MedicoRepository;

@RestController
@RequestMapping("/funcionario/medico")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public String createMedico(@RequestBody Medico medico) {
        medicoRepository.insertMedico(medico);
        return "Médico inserido!\n";
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

    @GetMapping
    public List<Medico> getMedicos(){
        return medicoRepository.getAllMedicos();
    }
}
