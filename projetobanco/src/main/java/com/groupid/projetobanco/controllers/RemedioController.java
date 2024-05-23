package com.groupid.projetobanco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupid.projetobanco.models.Remedio;
import com.groupid.projetobanco.repository.RemedioRepository;

@RestController
@RequestMapping("/remedio")
public class RemedioController {

    @Autowired
    private RemedioRepository remedioRepository;

    @PostMapping
    public String createRemedio(@RequestBody Remedio remedio){
        remedioRepository.insertRemedio(remedio);
        return "Remédio inserido!\n";
    }

    @DeleteMapping("/{codigo}")
    public String deleteRemedio(@PathVariable int codigo) {
        boolean deleted = remedioRepository.deleteRemedio(codigo);
        if(deleted){
            return "Remédio deletado!\n";
        } else {
            return "O Remédio com esse código não existe no banco de dados!\n";
        }    
    }

    @GetMapping
    public List<Remedio> getRemedio(){
        return remedioRepository.getAllRemedios();
    }

}
