package com.redesocial.ppads.service;

import com.redesocial.ppads.entity.Curtida;
import com.redesocial.ppads.repository.CurtidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurtidaService {
    @Autowired
    private CurtidaRepository curtidaRepository;

    public Curtida createCurtida(Curtida curtida){
        return curtidaRepository.save(curtida);
    }

    public List<Curtida> readAllCurtida(){
        return curtidaRepository.findAll();
    }

    public Curtida readById(Integer id){
        return curtidaRepository.findById(id).get();
    }

    public boolean verificaCurtida(Integer idUsuario, Integer idPost) {
        Curtida curtida = curtidaRepository.findByIdUsuarioCurtiuAndIdPostCurtido(idUsuario,idPost);
        if(curtida.getIdPostCurtido().equals(idPost) && curtida.getIdUsuarioCurtiu().equals(idUsuario)){
            return true;
        }
        return false;
    }

    public boolean remove(Integer idUsuario, Integer idPost) {
        Curtida curtida = curtidaRepository.findByIdUsuarioCurtiuAndIdPostCurtido(idUsuario,idPost);
        if(curtida.getIdPostCurtido().equals(idPost) && curtida.getIdUsuarioCurtiu().equals(idUsuario)){
            curtidaRepository.delete(curtida);
            return true;
        }
        return false;
    }
}
