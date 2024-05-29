package com.groupid.projetobanco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupid.projetobanco.models.Remedio;
import com.groupid.projetobanco.repository.RemedioRepository;

/**
 *
 * @author Matheus Gomes
 */
@Controller
@RequestMapping("/remedio")
public class RemedioController {

    @Autowired
    private RemedioRepository remedioRepository;

    @GetMapping
    public String getMedicos() {
        return "remedio_index";
    }

    @PostMapping
    public String createRemedio(@RequestBody Remedio remedio) {
        boolean inserted = remedioRepository.insertRemedio(remedio);
        
        if (inserted) {
            return "redirect:/remedio/lista";
        } 
        
        else {
            return "error";
        }
    }

    @DeleteMapping("/deletar/{codigo}")
    public ResponseEntity<String> deleteRemedio(@PathVariable int codigo) {
        boolean deleted = remedioRepository.deleteRemedio(codigo);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.OK).body("Remédio deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O remédio com esse código não existe no banco de dados!");
        }
    }

    @GetMapping("/lista")
    public String getRemedios(Model model) {
        List<Remedio> remedios = remedioRepository.getAllRemedios();
        model.addAttribute("remedios", remedios);
        return "lista_remedios";
    }
    

    @PutMapping("/atualizar/{codigo}")
    public ResponseEntity<String> updateRemedio(@PathVariable int codigo, @RequestBody Remedio remedio) {
        remedio.setCodigo(codigo);
        remedioRepository.updateRemedio(remedio);
        return ResponseEntity.status(HttpStatus.OK).body("Remédio atualizado com sucesso!");
    } 
    
    @GetMapping("/lista/Clonazepam")
    public String getRemediosClonazepam(Model model) {
        List<Remedio> remedios = remedioRepository.getAllRemediosPrincipioAtivoClonazepam();
        model.addAttribute("remedios", remedios);
        return "lista_remedios";
    }
}
