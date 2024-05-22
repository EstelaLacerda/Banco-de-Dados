package com.groupid.projetobanco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupid.projetobanco.models.Funcionario;
import com.groupid.projetobanco.repository.FuncionarioRepository;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("funcionario", new Funcionario(0, null, null));
        return "funcionarioForm"; // Nome do template Thymeleaf (funcionarioForm.html)
    }

    @PostMapping
    public String createFuncionario(@ModelAttribute Funcionario funcionario, Model model){
        boolean inserted = funcionarioRepository.insertFuncionario(funcionario);
        
        if (inserted) {
            model.addAttribute("message", "Funcionario inserido com sucesso!");
        } else {
            model.addAttribute("message", "Já existe um funcionário com essa matrícula.");
        }
        return "funcionarioForm"; // Nome do template Thymeleaf (funcionarioForm.html)
    }

    @GetMapping("/lista")
    public String getFuncionario(Model model){
        List<Funcionario> funcionarios = funcionarioRepository.getAllFuncionarios();
        model.addAttribute("funcionarios", funcionarios);
        return "lista_funcionarios"; // Nome do template Thymeleaf (lista_funcionarios.html)
    }
}
