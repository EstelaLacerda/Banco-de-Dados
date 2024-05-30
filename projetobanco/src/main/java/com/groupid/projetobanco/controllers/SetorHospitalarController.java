package com.groupid.projetobanco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupid.projetobanco.models.Setor_hospitalar;
import com.groupid.projetobanco.repository.SetorHospitalarRepository;

@Controller
@RequestMapping("/setor")
public class SetorHospitalarController {
    @Autowired
    private SetorHospitalarRepository setorHospitalarRepository;

    @GetMapping
    public String getSetores() {
        return "setor_index";
    }

    @GetMapping("/lista")
    public String getAllSetores(Model model) {
        List<Setor_hospitalar> setor_hospitalar = setorHospitalarRepository.getAllSetoresHospitalar();
        model.addAttribute("setor_hospitalar", setor_hospitalar);
        return "lista_setor";
    }

    @PostMapping
    public String createSetorHospitalar(@RequestBody Setor_hospitalar setor_hospitalar){
        setorHospitalarRepository.insertSetorHospitalar(setor_hospitalar);
        return "Setor Hospitalar inserido!\n";
    }

    @PostMapping("deletar/{codigo_setor}")
    public String deleteSetorHospitalar(@PathVariable int codigo_setor) {
        boolean deleted = setorHospitalarRepository.deleteSetorHospitalar(codigo_setor);
        if (deleted) {
            return "redirect:/setor/lista";
        } 
        
        else {
            return "redirect:/setor/lista";
        }    
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
