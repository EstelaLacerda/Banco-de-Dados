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

import com.groupid.projetobanco.models.Setor_hospitalar;
import com.groupid.projetobanco.repository.SetorHospitalarRepository;

@RestController
@RequestMapping("/setorhospitalar")
public class SetorHospitalarController {
    @Autowired
    private SetorHospitalarRepository setorHospitalarRepository;

    @PostMapping
    public String createSetorHospitalar(@RequestBody Setor_hospitalar Setor_hospitalar){
        SetorHospitalarRepository.insertSetorHospitalar(Setor_hospitalar);
        return "Setor Hospitalar inserido!\n";
    }

    @DeleteMapping("/{codigo_setor}")
    public String deleteSetorHospitalar(@PathVariable int codigo_setor) {
        boolean deleted = SetorHospitalarRepository.deleteSetorHospitalar(codigo_setor);
        if(deleted){
            return "Setor Hospitalar deletado!\n";
        } else {
            return "O Setor Hospitalar com esse código não existe no banco de dados!\n";
        }    
    }

    @GetMapping
    public List<Setor_hospitalar> getSetoreshospitalar(){
        return setorHospitalarRepository.getAllSetoresHospilar();
    }

}

