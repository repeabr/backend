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
        List<Curtida> curtidas = curtidaRepository.findAll();
        if (curtidas != null){
            for (Curtida c: curtidas) {
                if(c.getIdUsuarioCurtiu().equals(idUsuario) && c.getIdPostCurtido().equals(idPost)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean remove(Integer idUsuario, Integer idPost) {
        List<Curtida> curtidas = curtidaRepository.findAll();
        if (curtidas != null){
            for (Curtida c: curtidas) {
                if(c.getIdUsuarioCurtiu().equals(idUsuario) && c.getIdPostCurtido().equals(idPost)){
                    curtidaRepository.delete(c);
                    return true;
                }
            }
        }
        return false;
    }
}
