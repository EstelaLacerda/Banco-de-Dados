package com.groupid.projetobanco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupid.projetobanco.models.Funcionario;
import com.groupid.projetobanco.repository.FuncionarioRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("funcionario", new Funcionario(null, null));
        return "funcionarioForm";
    }

    @GetMapping("/outro/lista")
    public String getFuncionarioOutro(Model model) {
        List<Funcionario> funcionarios = funcionarioRepository.getAllFuncionariosOutro();
        model.addAttribute("funcionarios", funcionarios);
        return "lista_outros";
    }

    @PostMapping
    public String createFuncionario(@ModelAttribute Funcionario funcionario, Model model, HttpSession session) {
        boolean inserted = funcionarioRepository.insertFuncionario(funcionario);

        if (inserted) {
            model.addAttribute("message", "Funcionário inserido com sucesso!");

            String cargo = funcionario.getCargo().trim();

            if ("Médico".equalsIgnoreCase(cargo)) {
                return "redirect:/funcionario/lista";
            } 
            
            else if ("Farmacêutico".equalsIgnoreCase(cargo)) {
                return "redirect:/funcionario/lista";
            } 
            
            else if ("Outro".equalsIgnoreCase(cargo)) {
                return "redirect:/funcionario/lista";
            } 
            
            else {
                return "redirect:/funcionario";
            }
        } 
        
        else {
            model.addAttribute("message", "Já existe um Funcionário com essa matrícula.");
            return "funcionarioForm";
        }
    }
    
    @PostMapping("/deletar/{matricula}")
    public String deleteFuncionario(@PathVariable int matricula, Model model) {
        boolean deleted = funcionarioRepository.deleteFuncionario(matricula);
        if (deleted) {
            model.addAttribute("message", "Funcionário deletado com sucesso!");
        } else {
            model.addAttribute("message", "O Funcionário com essa matrícula não existe no banco de dados!");
        }
        return "redirect:/funcionario/lista";
    }


    @GetMapping("/lista")
    public String getFuncionario(Model model) {
        List<Funcionario> funcionarios = funcionarioRepository.getAllFuncionarios();
        model.addAttribute("funcionarios", funcionarios);
        return "lista_funcionarios";
    }
}
