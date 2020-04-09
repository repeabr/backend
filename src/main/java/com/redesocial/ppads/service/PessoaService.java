package com.redesocial.ppads.service;

import com.redesocial.ppads.entity.Pessoa;
import com.redesocial.ppads.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa login(Pessoa pessoa){
        List<Pessoa> lista = pessoaRepository.findAll();
        for (Pessoa p : lista) {
            if (p.getEmail().equals(pessoa.getEmail())
                    && p.getSenha().equals(pessoa.getSenha())) {
                return p;
            }
        }
        return null;
    }

    public Pessoa create(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> readAll(){
        return pessoaRepository.findAll();
    }

    public List<Pessoa> readAllExceptEmail(String email){
        List<Pessoa> lista = pessoaRepository.findAll();
        Pessoa pessoa = pessoaRepository.findByEmail(email);
        for(Pessoa p: lista){
            if (p == pessoa){
                lista.remove(p);
                return lista;
            }
        }
        return null;
    }

    public Pessoa readById(Integer id){
        return pessoaRepository.findById(id).get();
    }

    public Pessoa readByEmail(String email) {
        return pessoaRepository.findByEmail(email);
    }

    public Pessoa update(Pessoa pessoa){
        if (pessoaRepository.existsById(pessoa.getId())){
            Pessoa p = pessoaRepository.findById(pessoa.getId()).get();
            p.setEmail(pessoa.getEmail());
            p.setSenha(pessoa.getSenha());

            p.setCurriculo(pessoa.getCurriculo());
            p.setFormacao(pessoa.getFormacao());
            p.setInfos(pessoa.getInfos());
            p.setInteresses(pessoa.getInteresses());
            p.setTrabalho(pessoa.getTrabalho());
            return pessoaRepository.save(p);
        }
        return null;
    }

    public boolean delete(Integer id){
        if (pessoaRepository.existsById(id)){
            pessoaRepository.delete(pessoaRepository.findById(id).get());
            return true;
        }
        return false;
    }
}
