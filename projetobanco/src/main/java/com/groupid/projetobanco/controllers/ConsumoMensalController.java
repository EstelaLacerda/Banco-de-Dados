package com.groupid.projetobanco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.groupid.projetobanco.models.Consumo_mensal;
import com.groupid.projetobanco.repository.ConsumoMensalRepository;

@RestController
@RequestMapping("/consumomensal")
public class ConsumoMensalController {
    
    @Autowired
    private ConsumoMensalRepository consumoMensalRepository;

    @PostMapping("/create")
    public String createConsumoMensal(@RequestBody Consumo_mensal consumoMensal) {
        consumoMensalRepository.insertConsumoMensal(consumoMensal);
        return "Consumo mensal inserido com sucesso!\n";
    }

    @DeleteMapping("/delete/{codigo}")
    public String deleteConsumoMensal(@PathVariable int codigo) {
        boolean deleted = consumoMensalRepository.deleteConsumoMensal(codigo);
        if (deleted) {
            return "Consumo mensal deletado com sucesso!\n";
        } else {
            return "Não foi possível excluir o consumo mensal ou não foi encontrado na base de dados!\n";
        }
    }

    @GetMapping("/all")
    public List<Consumo_mensal> getAllConsumoMensal(){
        return consumoMensalRepository.getAllConsumoMensal();
    }

    @PutMapping("/update")
    public String updateConsumoMensal(@RequestBody Consumo_mensal consumoMensal) {
        boolean updated = consumoMensalRepository.updateConsumoMensal(consumoMensal);
        if (updated) {
            return "Consumo mensal atualizado com sucesso!\n";
        } else {
            return "Não foi possível atualizar o consumo mensal ou não foi encontrado na base de dados!\n";
        }
    }
}
