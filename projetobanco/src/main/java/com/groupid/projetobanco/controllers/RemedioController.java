package com.groupid.projetobanco.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.groupid.projetobanco.models.Remedio;
import com.groupid.projetobanco.repository.RemedioRepository;

@Controller
@RequestMapping("/remedio")
public class RemedioController {

    @Autowired
    private RemedioRepository remedioRepository;

    @GetMapping
    public String getMedicos(Model model) {
        return "remedio_index";
    }

    @PostMapping
    public String createRemedio(Remedio remedio, @RequestParam("data_abertura") @DateTimeFormat(pattern = "dd-MM-yyyy") Date dataAbertura, @RequestParam("validade") @DateTimeFormat(pattern = "dd-MM-yyyy") Date validade) {
        remedio.setData_abertura(dataAbertura);
        remedio.setValidade(validade);
    
        remedioRepository.insertRemedio(remedio);
        return "redirect:/remedio/lista";
    }    

    @PostMapping("/deletar/{codigo}")
    public String deleteRemedio(@PathVariable int codigo, Model model) {
        boolean deleted = remedioRepository.deleteRemedio(codigo);
        if (deleted) {
            model.addAttribute("message", "Remédio deletado com sucesso!");
        } else {
            model.addAttribute("message", "O Remédio com esse código não existe no banco de dados!");
        }
        return "redirect:/remedio/lista";
    }

    @GetMapping("/lista")
    public String getRemedios(Model model) {
        List<Remedio> remedios = remedioRepository.getAllRemedios();
        model.addAttribute("remedios", remedios);
        return "lista_remedios";
    }

}
