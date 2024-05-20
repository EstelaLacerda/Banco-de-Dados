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

import com.groupid.projetobanco.models.Farmaceutico;
import com.groupid.projetobanco.repository.FarmaceuticoRepository;

@RestController
@RequestMapping("/funcionario/farmaceutico")
public class FarmaceuticoController {

    @Autowired
    private FarmaceuticoRepository farmaceuticoRepository;

    @PostMapping
    public String createFarmaceutico(@RequestBody Farmaceutico farmaceutico) {
        boolean inserted = farmaceuticoRepository.insertFarmaceutico(farmaceutico);
    
        if (inserted) {
            return "Farmacêutico inserido!\n";
        } 
        
        else {
            return "Já existe um farmacêutico com essa matrícula.\n";
        }
    }

    @DeleteMapping("/{matricula_farmaceutico}")
    public String deleteFarmaceutico(@PathVariable int matricula_farmaceutico) {
        boolean deleted = farmaceuticoRepository.deleteFarmaceutico(matricula_farmaceutico);
        if (deleted) {
            return "Farmacêutico deletado!\n";
        } 
        
        else {
            return "O Farmacêutico com essa matrícula não existe no banco de dados!\n";
        }
    }

    @GetMapping
    public List<Farmaceutico> getFarmaceutico(){
        return farmaceuticoRepository.getAllFarmaceuticos();
    }
}
