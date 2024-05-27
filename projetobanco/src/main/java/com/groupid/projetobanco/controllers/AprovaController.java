package com.groupid.projetobanco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.groupid.projetobanco.models.Aprova;
import com.groupid.projetobanco.repository.AprovaRepository;

@RestController
@RequestMapping("/aprova")
public class AprovaController {

    @Autowired
    private AprovaRepository aprovaRepository;

    @PostMapping
    public String createAprova(@RequestBody Aprova aprova) {
        aprovaRepository.insertAprova(aprova);
        return "Aprovação registrada com sucesso!\n";
    }

    @DeleteMapping("/{matricula}/{idReceita}")
    public String deleteAprova(@PathVariable int matricula, @PathVariable int idReceita) {
        boolean deleted = aprovaRepository.deleteAprova(matricula, idReceita);
        if (deleted) {
            return "Aprovação excluída com sucesso!\n";
        } else {
            return "Não foi possível excluir a aprovação ou não foi encontrada na base de dados!\n";
        }
    }

    @GetMapping("/all")
    public List<Aprova> getAllAprovacoes() {
        return aprovaRepository.getAllAprova();
    }
}
