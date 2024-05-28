package com.groupid.projetobanco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.groupid.projetobanco.models.Paciente;
import com.groupid.projetobanco.repository.PacienteRepository;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    public String createPaciente(@RequestBody Paciente paciente) {
        try {
            pacienteRepository.insertPaciente(paciente);
            return "Paciente inserido!\n";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao inserir paciente: " + e.getMessage() + "\n";
        }
    }

    @DeleteMapping("/{codigo_paciente}")
    public String deletePaciente(@PathVariable int codigo_paciente) {
        boolean deleted = pacienteRepository.deletePaciente(codigo_paciente);
        if (deleted) {
            return "Paciente deletado!\n";
        } else {
            return "O paciente com essas informações não existe no banco de dados!\n";
        }
    }

    @GetMapping("/allpacientes")
    public List<Paciente> getPacientes() {
        return pacienteRepository.getAllPacientes();
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
