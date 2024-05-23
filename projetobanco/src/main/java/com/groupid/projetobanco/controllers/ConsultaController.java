package com.groupid.projetobanco.controllers;

import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.groupid.projetobanco.models.Consulta;
import com.groupid.projetobanco.repository.ConsultaRepository;

@RestController
@RequestMapping("/consulta/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;

    @PostMapping
    public String createConsulta(@RequestBody Consulta consulta) {
        consultaRepository.insertConsulta(consulta);
        return "Consulta inserida!\n";
    }


    @DeleteMapping("/{hora} {cpf_Paciente} {matricula_medico}")
    public String deleteConsulta(@PathVariable Time hora, String cpf_Paciente, int matricula_medico) {
        boolean deleted = consultaRepository.deleteConsulta(matricula_medico, cpf_Paciente, hora);
        if (deleted) {
            return "Consulta deletada!\n";
        } else {
            return "Não existe os dados dessa consulta no no banco de dados!\n";
        }
    }

    @GetMapping("/allconsulta")
    public List<Consulta> getConsultas(){
        return consultaRepository.getAllConsultas();
    }
}
