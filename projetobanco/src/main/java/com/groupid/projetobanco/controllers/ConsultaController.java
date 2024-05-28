package com.groupid.projetobanco.controllers;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.groupid.projetobanco.models.Consulta;
import com.groupid.projetobanco.repository.ConsultaRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;
    private static final Logger logger = LoggerFactory.getLogger(ConsultaController.class);

    @PostMapping("/create")
    public String createConsulta(@RequestBody Consulta consulta) {
        consultaRepository.insertConsulta(consulta);
        return "Consulta inserida com sucesso!\n";
    }

    @DeleteMapping("/{dataHora}/{codigoPaciente}/{matriculaMedico}")
    public String deleteConsulta(@PathVariable String dataHora, @PathVariable int codigoPaciente, @PathVariable int matriculaMedico) {
        try {
            // Decodificar a dataHora para evitar problemas com caracteres especiais
            String decodedDataHora = URLDecoder.decode(dataHora, StandardCharsets.UTF_8.toString());
            // Substituir 'T' por um espaço para formar o timestamp corretamente
            String timestampStr = decodedDataHora.replace("T", " ");
            // Adicionar segundos para formar um timestamp válido
            if (timestampStr.length() == 16) {
                timestampStr += ":00";
            }
            Timestamp timestamp = Timestamp.valueOf(timestampStr);
            
            logger.info("Tentando deletar consulta com dataHora: " + timestamp + ", codigoPaciente: " + codigoPaciente + ", matriculaMedico: " + matriculaMedico);
            
            boolean deleted = consultaRepository.deleteConsulta(timestamp, codigoPaciente, matriculaMedico);
            if (deleted) {
                return "Consulta deletada com sucesso!\n";
            } else {
                return "Não foi possível excluir a consulta ou não foi encontrada na base de dados!\n";
            }
        } catch (IllegalArgumentException e) {
            logger.error("Erro no formato da data e hora: " + dataHora, e);
            return "Formato de data e hora inválido!\n";
        } catch (Exception e) {
            logger.error("Erro ao deletar a consulta", e);
            return "Erro interno ao tentar deletar a consulta!\n";
        }
    }

    @GetMapping("/all")
    public List<Consulta> getAllConsultas(){
        return consultaRepository.getAllConsultas();
    }
}

