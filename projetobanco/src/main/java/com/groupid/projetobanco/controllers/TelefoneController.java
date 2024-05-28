package com.groupid.projetobanco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupid.projetobanco.models.Telefone;
import com.groupid.projetobanco.repository.TelefoneRepository;

@RestController
@RequestMapping("/telefone")
public class TelefoneController {

    @Autowired
    private TelefoneRepository telefoneRepository;

    @PostMapping
    public String createTelefone(@RequestBody Telefone telefone) {
        telefoneRepository.insertTelefone(telefone);
        return "Telefone inserido!\n";
    }

    @DeleteMapping("/{id}")
    public String deleteTelefone(@PathVariable int id) {
        boolean deleted = telefoneRepository.deleteTelefone(id);
        if (deleted) {
            return "Telefone excluído!\n";
        } else {
            return "O telefone com esse ID não existe no banco de dados!\n";
        }
    }

    @GetMapping("/all")
    public List<Telefone> getAllTelefones() {
        return telefoneRepository.getAllTelefones();
    }

    @PutMapping("/atualizar/{id}")
    public String updateTelefone(@PathVariable int id, @RequestBody Telefone telefone) {
        telefone.setId(id);
        boolean updated = telefoneRepository.updateTelefone(telefone);
        if (updated) {
            return "Telefone atualizado!\n";
        } else {
            return "Não foi possível atualizar o telefone com esse ID!\n";
        }
    }
}
