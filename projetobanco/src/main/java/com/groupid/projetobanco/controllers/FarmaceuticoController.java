package com.groupid.projetobanco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.groupid.projetobanco.models.Farmaceutico;
import com.groupid.projetobanco.repository.FarmaceuticoRepository;

@RestController
@RequestMapping("/funcionario/farmaceutico")
public class FarmaceuticoController {

    @Autowired
    private FarmaceuticoRepository farmaceuticoRepository;

    @PostMapping
    public String createFarmaceutico(@RequestBody Farmaceutico farmaceutico) {
        farmaceuticoRepository.insertFarmaceutico(farmaceutico);
        return "Farmacêutico inserido!\n";
    }

    @DeleteMapping("/{matricula_farmaceutico}")
    public String deleteFarmaceutico(@PathVariable int matricula_farmaceutico) {
        boolean deleted = farmaceuticoRepository.deleteFarmaceutico(matricula_farmaceutico);
        if (deleted) {
            return "Farmacêutico deletado!\n";
        } else {
            return "O Farmacêutico com essa matrícula não existe no banco de dados!\n";
        }
    }

    @GetMapping
    public List<Farmaceutico> getFarmaceutico(){
        return farmaceuticoRepository.getAllFarmaceuticos();
    }
}
