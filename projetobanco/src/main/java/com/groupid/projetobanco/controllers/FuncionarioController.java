package com.groupid.projetobanco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.groupid.projetobanco.models.Funcionario;
import com.groupid.projetobanco.repository.FuncionarioRepository;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @PostMapping
    public String crimes(@RequestBody Funcionario funcionario) {
        
        funcionarioRepository.insertFuncionario(funcionario);

        return "Funcionario Legal Criado";
    }

    @RequestMapping(value = "/cadastro", method = RequestMethod.GET)
    public ModelAndView funcionarioForm(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("funcionarioForm");
        return mv;
    }

    @RequestMapping(value = "/cadastro", method = RequestMethod.POST)
    public ModelAndView funcionarioForm(Funcionario funcionario){
        funcionarioRepository.insertFuncionario(funcionario);;
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @GetMapping("/lista")
    public ModelAndView getAllFuncionarios(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("funcionario", funcionarioRepository.getAllFuncionarios());
        mv.setViewName("listaFuncionario");
        return mv;
    }

    @GetMapping("/excluir/{matricula}")
    public String excluirFuncionario(@PathVariable("matricula") Integer matricula, Model model){
        funcionarioRepository.deleteFuncionario(matricula);
        model.addAttribute("funcionario", funcionarioRepository.getAllFuncionarios());
        return "listaFuncionario";
    }

    @PostMapping
    public String createFuncionario(@RequestBody Funcionario funcionario){
        funcionarioRepository.insertFuncionario(funcionario);;
        return "Funcionario inserido!\n";
    }

    @DeleteMapping("/{matricula}")
    public String deletejogador(@PathVariable int matricula){
        boolean deleted = funcionarioRepository.deleteFuncionario(matricula);
        if(deleted){
            return "Funcionario deletado!\n";
        } else {
            return "O Funcionario com essas informações não existe no banco de dados!\n";
        }
    }

    @GetMapping
    public List<Funcionario> getFuncionario(){
        return funcionarioRepository.getAllFuncionarios();
    }
}
