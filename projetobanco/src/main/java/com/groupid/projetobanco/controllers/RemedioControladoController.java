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

import com.groupid.projetobanco.models.RemedioControlado;
import com.groupid.projetobanco.repository.RemedioControladoRepository;

@RestController
@RequestMapping("git")
public class RemedioControladoController {
    @Autowired
    private RemedioControladoRepository remedioControladoRepository;

    @PostMapping
    public String createRemedioControlado(@RequestBody RemedioControlado remedio_controlado){
        remedioControladoRepository.insertRemedioControlado(remedio_controlado);
        return "Remédio controlado inserido!\n";
    }

    @DeleteMapping("/{fk_Remedio_codigo}")
    public String deleteRemedioControlado(@PathVariable int fk_Remedio_codigo){
        boolean deleted = remedioControladoRepository.deleteRemedioControlado(fk_Remedio_codigo);
        if(deleted){
            return "Remédio controlado deletado!\n";
        } else {
            return "O Remédio controlado com esse código não existe no banco de dados!\n";
        }
    }

    @GetMapping
    public List<RemedioControlado> getRemedioControlado(){
        return remedioControladoRepository.getAllRemediosControlados();
    }

}
    

