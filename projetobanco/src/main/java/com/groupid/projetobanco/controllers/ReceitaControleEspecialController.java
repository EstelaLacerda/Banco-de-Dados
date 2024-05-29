package com.groupid.projetobanco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupid.projetobanco.models.Receita_controle_especial;
import com.groupid.projetobanco.repository.ReceitaControleEspecialRepository;

@Controller
@RequestMapping("/receita/controle_especial")
public class ReceitaControleEspecialController {

    @Autowired
    private ReceitaControleEspecialRepository receitaControleEspecialRepository;

    @PostMapping
    public String createReceitaControleEspecial(@RequestBody Receita_controle_especial receitaControleEspecial) {
        receitaControleEspecialRepository.insertReceitaControleEspecial(receitaControleEspecial);
        return "Receita controle especial inserida!\n";
    }

    @DeleteMapping("deletar/{id_receita}")
    public String deleteReceitaControleEspecial(@PathVariable int idReceita) {
        boolean deleted = receitaControleEspecialRepository.deleteReceitaControleEspecial(idReceita);
        if (deleted) {
            return "redirect:/receita/controle_especial/lista";
        } 
        
        else {
            return "redirect:/receita/controle_especial/lista";
        }
    }
    
    @GetMapping("/lista")
    public String getAllReceitas(Model model){
        List<Receita_controle_especial> receitas_controle_especial = receitaControleEspecialRepository.getAllReceitasControleEspecial();
        model.addAttribute("receitas_controle_especial", receitas_controle_especial);
        return "lista_receitas_controle_especial";
    }  

    @PutMapping("/{id_receita}")
    public String updateReceitaControleEspecial(@PathVariable int id_receita, @RequestBody Receita_controle_especial receitaControleEspecial) {
        boolean updated = receitaControleEspecialRepository.updateReceitaControleEspecial(receitaControleEspecial);
        if (updated) {
            return "Receita controle especial atualizada!\n";
        } else {
            return "Não foi possível atualizar a receita controle especial com esse ID!\n";
        }
    }
}
