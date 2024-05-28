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

import com.groupid.projetobanco.models.Setor_hospitalar;
import com.groupid.projetobanco.repository.SetorHospitalarRepository;

@RestController
@RequestMapping("/setorhospitalar")
public class SetorHospitalarController {
    @Autowired
    private SetorHospitalarRepository setorHospitalarRepository;

    @PostMapping
    public String createSetorHospitalar(@RequestBody Setor_hospitalar setor_hospitalar){
        setorHospitalarRepository.insertSetorHospitalar(setor_hospitalar);
        return "Setor Hospitalar inserido!\n";
    }

    @DeleteMapping("/{codigo_setor}")
    public String deleteSetorHospitalar(@PathVariable int codigo_setor) {
        boolean deleted = setorHospitalarRepository.deleteSetorHospitalar(codigo_setor);
        if(deleted){
            return "Setor Hospitalar deletado!\n";
        } else {
            return "O Setor Hospitalar com esse código não existe no banco de dados!\n";
        }    
    }

    @GetMapping("/allsetorhospitalar")
    public List<Setor_hospitalar> getSetoreshospitalar(){
        return setorHospitalarRepository.getAllSetoresHospitalar();
    }

    @PutMapping("/atualizar/{codigo_setor}")
    public String updateSetorHospitalar(@PathVariable int codigo_setor, @RequestBody Setor_hospitalar setor_hospitalar) {
        setor_hospitalar.setCodigoSetor(codigo_setor);
        boolean updated = setorHospitalarRepository.updateSetorHospitalar(setor_hospitalar);
        if(updated){
            return "Setor Hospitalar atualizado!\n";
        } else {
            return "Não foi possível atualizar o Setor Hospitalar com esse código!\n";
        }
    }
}
