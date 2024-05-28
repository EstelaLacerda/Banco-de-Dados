package com.groupid.projetobanco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.groupid.projetobanco.models.Receita_controle_especial;
import com.groupid.projetobanco.repository.ReceitaControleEspecialRepository;

@RestController
@RequestMapping("/remedio/controlado")
public class ReceitaControleEspecialController {

    @Autowired
    private ReceitaControleEspecialRepository receitaControleEspecialRepository;

    @PostMapping
    public String createReceitaControleEspecial(@RequestBody Receita_controle_especial receitaControleEspecial) {
        receitaControleEspecialRepository.insertReceitaControleEspecial(receitaControleEspecial);
        return "Receita controle especial inserida!\n";
    }

    @DeleteMapping("/{id_receita}")
    public String deleteReceitaControleEspecial(@PathVariable int id_receita) {
        boolean deleted = receitaControleEspecialRepository.deleteReceitaControleEspecial(id_receita);
        if (deleted) {
            return "Receita controle especial deletada!\n";
        } else {
            return "A receita controle especial com esse ID não existe no banco de dados!\n";
        }
    }

    @GetMapping("/allreceitacontroleespecial")
    public List<Receita_controle_especial> getReceitasControleEspecial() {
        return receitaControleEspecialRepository.getAllReceitasControleEspecial();
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
