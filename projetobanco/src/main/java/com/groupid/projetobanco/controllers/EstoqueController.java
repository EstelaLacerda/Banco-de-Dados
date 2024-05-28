package com.groupid.projetobanco.controllers;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupid.projetobanco.models.Estoque;
import com.groupid.projetobanco.repository.EstoqueRepository;

@Controller
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @GetMapping
    public String getEstoques(Model model) {
        return "estoque_index";
    }
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @PostMapping("/estoque")
    public String createEstoque(@ModelAttribute Estoque estoque) {
        boolean inserted = estoqueRepository.insertEstoque(estoque);
        
        if (inserted) {
            return "redirect:/estoque/lista";
        } else {
            return "error";
        }
    }

    @PostMapping("/deletar/{cod_estoque}")
    public String deleteEstoque(@PathVariable int cod_estoque, Model model) {
        boolean deleted = estoqueRepository.deleteEstoque(cod_estoque);
        if (deleted) {
            model.addAttribute("message", "Estoque deletado com sucesso!");
        } else {
            model.addAttribute("message", "O Estoque com esse código não existe no banco de dados!");
        }
        return "redirect:/estoque/lista";
    }


    @GetMapping("/lista")
    public String getEstoque(Model model) {
        List<Estoque> estoques = estoqueRepository.getAllEstoques();
        model.addAttribute("estoques", estoques);
        return "lista_estoques";
    }

    @PostMapping("/atualizar/{cod_estoque}")
    public String updateEstoque(@PathVariable int cod_estoque, @ModelAttribute Estoque estoque, Model model) {
        estoque.setCodigoEstoque(cod_estoque); // Define o código do estoque a ser atualizado
        estoqueRepository.updateEstoque(estoque); // Atualiza o estoque
        model.addAttribute("message", "Estoque atualizado com sucesso!");
        return "redirect:/estoque/lista";
    }


}
