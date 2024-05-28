package com.groupid.projetobanco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.groupid.projetobanco.models.Remedio;
import com.groupid.projetobanco.repository.RemedioRepository;

@RestController
@RequestMapping("/remedio")
public class RemedioController {

    @Autowired
    private RemedioRepository remedioRepository;

    @GetMapping
    public String getMedicos() {
        return "remedio_index";
    }

    @PostMapping
    public ResponseEntity<String> createRemedio(@RequestBody Remedio remedio) {
        boolean inserted = remedioRepository.insertRemedio(remedio);
        
        if (inserted) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Remédio inserido com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao inserir o remédio.");
        }
    }

    @DeleteMapping("/deletar/{codigo}")
    public ResponseEntity<String> deleteRemedio(@PathVariable int codigo) {
        boolean deleted = remedioRepository.deleteRemedio(codigo);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.OK).body("Remédio deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O remédio com esse código não existe no banco de dados!");
        }
    }

    @GetMapping("/lista")
    public List<Remedio> getRemedios() {
        return remedioRepository.getAllRemedios();
    }

    @PutMapping("/atualizar/{codigo}")
    public ResponseEntity<String> updateRemedio(@PathVariable int codigo, @RequestBody Remedio remedio) {
        remedio.setCodigo(codigo);
        remedioRepository.updateRemedio(remedio);
        return ResponseEntity.status(HttpStatus.OK).body("Remédio atualizado com sucesso!");
    }

    @GetMapping("/lista/Clonazepam")
    public List<Remedio> getRemediosClonazepam() {
        return remedioRepository.getAllRemediosPrincipioAtivoClonazepam();
    }    
}
