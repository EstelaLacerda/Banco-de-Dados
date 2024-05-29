package com.groupid.projetobanco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupid.projetobanco.models.Paciente;
import com.groupid.projetobanco.repository.PacienteRepository;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;


    @GetMapping
    public String getPacientes() {
        return "paciente_index";
    }

    @PostMapping
    public String createPaciente(@RequestBody Paciente paciente) {
        boolean inserted = pacienteRepository.insertPaciente(paciente);

        if (inserted) {
            return "redirect:/paciente/lista";
        } 
        
        else {
            return "error";
        }
    }

    @PostMapping("deletar/{codigo_paciente}")
    public String deletePaciente(@PathVariable int codigo_paciente) {
        boolean deleted = pacienteRepository.deletePaciente(codigo_paciente);
        if (deleted) {
            return "redirect:/paciente/lista";
        } 
        
        else {
            return "redirect:/paciente/lista";
        }
    }

    @GetMapping("/lista")
    public String getAllPacientes(Model model) {
        List<Paciente> pacientes = pacienteRepository.getAllPacientes();
        model.addAttribute("pacientes", pacientes);
        return "lista_pacientes";
    }

    @GetMapping("/lista/maiores_de_idade")
    public String getAllPacientesMaiorDeIdade(Model model) {
        List<Paciente> pacientes = pacienteRepository.getAllPacientesMaiorDeIdade();
        model.addAttribute("pacientes", pacientes);
        return "lista_pacientes_maiores";
    }

    @GetMapping("/lista/menores_de_idade")
    public String getAllPacientesMenorDeIdade(Model model) {
        List<Paciente> pacientes = pacienteRepository.getAllPacientesMenorDeIdade();
        model.addAttribute("pacientes", pacientes);
        return "lista_pacientes_menores";
    }
    
    @PutMapping("/{codigo_paciente}")
    public String updatePaciente(@PathVariable int codigo_paciente, @RequestBody Paciente paciente) {
        boolean updated = pacienteRepository.updatePaciente(paciente);
        if (updated) {
            return "Paciente atualizado!\n";
        } else {
            return "Não foi possível atualizar o paciente. Verifique se o paciente com o código fornecido existe no banco de dados.\n";
        }
    }

    
}
