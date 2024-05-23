package com.groupid.projetobanco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupid.projetobanco.models.Farmaceutico;
import com.groupid.projetobanco.repository.FarmaceuticoRepository;

@Controller
@RequestMapping("/funcionario/farmaceutico")
public class FarmaceuticoController {

    @Autowired
    private FarmaceuticoRepository farmaceuticoRepository;

    @PostMapping
    public String createFarmaceutico(@RequestBody Farmaceutico farmaceutico) {
        boolean inserted = farmaceuticoRepository.insertFarmaceutico(farmaceutico);
    
        if (inserted) {
            return "Farmacêutico inserido!\n";
        } else {
            return "Já existe um farmacêutico com essa matrícula.\n";
        }
    }

    @DeleteMapping("/deletar/{matricula_farmaceutico}")
    public String deleteFarmaceutico(@PathVariable int matricula_farmaceutico, Model model) {
        boolean deleted = farmaceuticoRepository.deleteFarmaceutico(matricula_farmaceutico);
        if (deleted) {
            model.addAttribute("message", "Farmacêutico deletado com sucesso!");
        } else {
            model.addAttribute("message", "O Farmacêutico com essa matrícula não existe no banco de dados!");
        }
        return "redirect:/funcionario/farmaceutico/lista";
    }


    @GetMapping("/lista")
    public String getFarmaceuticos(Model model) {
        List<Farmaceutico> farmaceuticos = farmaceuticoRepository.getAllFarmaceuticos();
        model.addAttribute("farmaceuticos", farmaceuticos);
        return "lista_farmaceuticos";
    }
}
