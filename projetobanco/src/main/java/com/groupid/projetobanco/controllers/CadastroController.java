package com.groupid.projetobanco.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupid.projetobanco.models.Farmaceutico;
import com.groupid.projetobanco.models.Funcionario;
import com.groupid.projetobanco.models.Medico;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {

    @GetMapping
    public String showCadastro(Model model) {
        return "cadastro";
    }

    @GetMapping("/funcionario")
    public String showForm(Model model) {
        model.addAttribute("funcionario", new Funcionario(0, null, null));
        return "funcionarioForm";
    }

    @GetMapping("/medico")
    public String showFormMedico(Model model) {
        model.addAttribute("medico", new Medico(null, 0));
        return "medicoForm";
    }

    @GetMapping("/farmaceutico")
    public String getFarmaceuticos(Model model) {
        model.addAttribute("farmaceuticos", new Farmaceutico(null, 0));
        return "farmaceuticoForm";
    }
}
