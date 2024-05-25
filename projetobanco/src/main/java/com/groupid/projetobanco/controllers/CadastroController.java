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

    @GetMapping("/funcionario")
    public String showForm(Model model) {
        model.addAttribute("funcionario", new Funcionario(0, null, null));
        return "funcionarioForm";
    }

    @GetMapping("/medico")
    public String showFormMedico(Model model) {
        model.addAttribute("medico", new Medico(0, null, null, null, 0));
        return "medicoForm";
    }

    @GetMapping("/farmaceutico")
    public String getFarmaceuticos(Model model) {
        model.addAttribute("farmaceuticos", new Farmaceutico(0, null, null, null, 0));
        return "farmaceuticoForm";
    }
}
