package com.groupid.projetobanco.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupid.projetobanco.models.Estoque;
import com.groupid.projetobanco.models.Farmaceutico;
import com.groupid.projetobanco.models.Funcionario;
import com.groupid.projetobanco.models.Medico;
import com.groupid.projetobanco.models.Remedio;

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

    @GetMapping("/remedio")
    public String showFormRemedio(Model model) {
        model.addAttribute("remedio", new Remedio(null, 0, null, null, null, null, null, 0, null));
        return "remedioForm";
    }

    @GetMapping("/estoque")
    public String showFormEstoque(Model model) {
        model.addAttribute("estoque", new Estoque(0, 0, null, null, null, null, null));
        return "estoqueForm";
    }
}
