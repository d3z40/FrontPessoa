package com.d3z40.frontpessoa.controllers;

import com.d3z40.frontpessoa.models.Pessoa;
import com.d3z40.frontpessoa.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;

@Controller
@RequestMapping(path = "/pessoas")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    public String index() {
        return "index";
    }

    @GetMapping("/lista-pessoas")
    public String getPessoas(Model model) {
        Pessoa[] pessoas = pessoaService.getPessoas();

        model.addAttribute("pessoas", pessoas);

        return "lista-pessoas";
    }

    @GetMapping("/cadastra-pessoa")
    public String cadastraPessoa(Pessoa pessoa, Model model) {

        model.addAttribute("pessoa", pessoa);

        return "cadastra-pessoa";
    }

    @PostMapping(value = "/deletar/{id}")
    public String deletePessoa(@PathVariable int id, Model model) {
        try {
            pessoaService.deletePessoa(id);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return getPessoas(model);
    }

    @PostMapping(value = "/savePessoa")
    public String savePessoa(@Valid Pessoa pessoa, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return cadastraPessoa(pessoa, model);
        }

        pessoaService.savePessoa(pessoa);
        return getPessoas(model);
    }

    @PostMapping(value = "/edit/{id}")
    public String editPessoa(@PathVariable int id, Model model) {
        Pessoa pessoa = pessoaService.getPessoaById(id);

        return cadastraPessoa(pessoa, model);
    }
}