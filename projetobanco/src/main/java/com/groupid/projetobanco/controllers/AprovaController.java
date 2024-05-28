package com.groupid.projetobanco.controllers;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.groupid.projetobanco.models.Aprova;
import com.groupid.projetobanco.repository.AprovaRepository;

@RestController
@RequestMapping("/aprova")
public class AprovaController {

    @Autowired
    private AprovaRepository aprovaRepository;
    private static final Logger logger = LoggerFactory.getLogger(AprovaController.class);

    @PostMapping
    public String createAprova(@RequestBody Aprova aprova) {
        aprovaRepository.insertAprova(aprova);
        return "Aprovação registrada com sucesso!\n";
    }

    @DeleteMapping("/{matricula}/{idReceita}")
    public String deleteAprova(@PathVariable int matricula, @PathVariable int idReceita) {
        boolean deleted = aprovaRepository.deleteAprova(matricula, idReceita);
        if (deleted) {
            return "Aprovação excluída com sucesso!\n";
        } else {
            return "Não foi possível excluir a aprovação ou não foi encontrada na base de dados!\n";
        }
    }

    @GetMapping("/all")
    public List<Aprova> getAllAprovacoes() {
        try {
            List<Aprova> aprovacoes = aprovaRepository.getAllAprova();
            if (aprovacoes == null || aprovacoes.isEmpty()) {
                logger.warn("Nenhuma aprovação encontrada.");
                throw new RuntimeException("Nenhuma aprovação encontrada.");
            }
            return aprovacoes;
        } catch (Exception e) {
            logger.error("Erro ao obter aprovações", e);
            throw new RuntimeException("Erro ao obter aprovações", e);
        }
    }
}
