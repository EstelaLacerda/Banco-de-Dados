package com.groupid.projetobanco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupid.projetobanco.models.Medico;
import com.groupid.projetobanco.repository.MedicoRepository;

@Controller
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

    @PostMapping("/deletar/{matricula_medico}")
    public String deleteMedico(@PathVariable int matricula_medico, Model model) {
        boolean deleted = medicoRepository.deleteMedico(matricula_medico);
        if (deleted) {
            model.addAttribute("message", "Médico deletado com sucesso!");
        } else {
            model.addAttribute("message", "O Médico com essa matrícula não existe no banco de dados!");
        }
        return "redirect:/funcionario/medico/lista";
    }    

    @GetMapping("/lista")
    public String getMedicos(Model model) {
        List<Medico> medicos = medicoRepository.getAllMedicos();
        model.addAttribute("medicos", medicos);
        return "lista_medicos";
    }
}