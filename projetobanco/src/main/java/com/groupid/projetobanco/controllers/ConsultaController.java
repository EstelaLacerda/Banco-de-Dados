package com.groupid.projetobanco.controllers;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.groupid.projetobanco.models.Consulta;
import com.groupid.projetobanco.repository.ConsultaRepository;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;

    @PostMapping("/create")
    public String createConsulta(@RequestBody Consulta consulta) {
        consultaRepository.insertConsulta(consulta);
        return "Consulta inserida com sucesso!\n";
    }

    @DeleteMapping("/delete/{dataHora}/{codigoPaciente}/{matriculaMedico}")
    public String deleteConsulta(@PathVariable Timestamp dataHora, @PathVariable int codigoPaciente, @PathVariable int matriculaMedico) {
        boolean deleted = consultaRepository.deleteConsulta(dataHora, codigoPaciente, matriculaMedico);
        if (deleted) {
            return "Consulta deletada com sucesso!\n";
        } else {
            return "Não foi possível excluir a consulta ou não foi encontrada na base de dados!\n";
        }
    }

    @GetMapping("/all")
    public List<Consulta> getAllConsultas(){
        return consultaRepository.getAllConsultas();
    }
}
