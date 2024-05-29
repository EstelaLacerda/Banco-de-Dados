package com.groupid.projetobanco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupid.projetobanco.models.Receita;
import com.groupid.projetobanco.repository.ReceitaRepository;


@Controller
@RequestMapping("/receita")
public class ReceitaController {

    @Autowired
    private ReceitaRepository receitaRepository;

    @PostMapping
    public String createReceita(@RequestBody Receita receita){
        boolean inserted = receitaRepository.insertReceita(receita);

        if (inserted) {
            return "redirect:/receita/lista";
        } 
        
        else {
            return "error";
        }
    }

    @PostMapping("deletar/{idReceita}")
    public String deleteReceita(@PathVariable int idReceita) {
        boolean deleted = receitaRepository.deleteReceita(idReceita);
        if (deleted) {
            return "redirect:/receita/lista";
        } 
        
        else {
            return "redirect:/receita/lista";
        }
    }

    @GetMapping
    public String getReceitas() {
        return "receita_index";
    }

    @GetMapping("/lista")
    public String getAllReceitas(Model model){
        List<Receita> receitas = receitaRepository.getAllReceitas();
        model.addAttribute("receitas", receitas);
        return "lista_receitas";
    }    

    @PutMapping("/atualizar/{id_receita}")
    public ResponseEntity<String> updateReceita(@PathVariable int id_receita, @RequestBody Receita receita) {
        receita.setIdReceita(id_receita);
        boolean updated = receitaRepository.updateReceita(receita);
        if (updated) {
            return ResponseEntity.ok("Receita atualizada com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível atualizar a receita com esse código!");
        }
    }
}
