package com.groupid.projetobanco.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.groupid.projetobanco.models.Consulta;
import com.groupid.projetobanco.repository.ConsultaRepository;

@Controller
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;
    private static final Logger logger = LoggerFactory.getLogger(ConsultaController.class);

    @GetMapping
    public String getConsultas() {
        return "consulta_index";
    }

    @PostMapping
    public String createConsulta(@RequestBody Consulta consulta) {
        consultaRepository.insertConsulta(consulta);
        return "redirect:/consulta/lista";
    }

    @PostMapping("deletar/{dataHora}/{codigoPaciente}/{matriculaMedico}")
    public String deleteConsulta(@PathVariable String dataHora, @PathVariable int codigoPaciente, @PathVariable int matriculaMedico, RedirectAttributes redirectAttributes) {
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
                redirectAttributes.addFlashAttribute("successMessage", "Consulta deletada com sucesso!");
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", "Não foi possível excluir a consulta ou não foi encontrada na base de dados!");
            }
        } catch (IllegalArgumentException e) {
            logger.error("Erro no formato da data e hora: " + dataHora, e);
            redirectAttributes.addFlashAttribute("errorMessage", "Formato de data e hora inválido!");
        } catch (UnsupportedEncodingException e) {
            logger.error("Erro ao deletar a consulta", e);
            redirectAttributes.addFlashAttribute("errorMessage", "Erro interno ao tentar deletar a consulta!");
        }
        
        return "redirect:/consulta/lista";
    }


    @GetMapping("/lista")
    public String getConsulta(Model model) {
        List<Consulta> consultas = consultaRepository.getAllConsultas();
        model.addAttribute("consultas", consultas);
        return "lista_consulta";
    }
}

