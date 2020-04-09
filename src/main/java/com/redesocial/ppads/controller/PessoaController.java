package com.redesocial.ppads.controller;

import com.redesocial.ppads.entity.Pessoa;
import com.redesocial.ppads.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/redesocial/pessoa")
@CrossOrigin("*")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/login")
    public Pessoa login(@RequestBody Pessoa pessoa){
        return pessoaService.login(pessoa);
    }

    @PostMapping("/cadastro")
    public Pessoa cadastroPessoa(@RequestBody Pessoa pessoa){
        return pessoaService.create(pessoa);
    }

    @GetMapping("/listar")
    public List<Pessoa> listaPessoa(){
        return pessoaService.readAll();
    }

    @GetMapping("/listarExceto/{email}")
    public List<Pessoa> listaExceto(@PathVariable String email){
        return pessoaService.readAllExceptEmail(email);
    }

    @GetMapping("/buscarPorId/{id}")
    public Pessoa buscaPessoaPorId(@PathVariable Integer id){
        return pessoaService.readById(id);
    }

    @GetMapping("/emailpessoa/{email}")
    public Pessoa buscaPessoaPorEmail(@PathVariable String email) { return pessoaService.readByEmail(email); }

    @PutMapping("/atualizar")
    public Pessoa atualizarPessoa(@RequestBody Pessoa pessoa){
        return pessoaService.update(pessoa);
    }

    @DeleteMapping("/deletar/{id}")
    public boolean deletarPessoa(@PathVariable Integer id){
        return pessoaService.delete(id);
    }

}
