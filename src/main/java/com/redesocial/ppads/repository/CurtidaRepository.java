package com.redesocial.ppads.repository;

import com.redesocial.ppads.entity.Curtida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurtidaRepository extends JpaRepository<Curtida, Integer> {
    List<Curtida> findByIdPostCurtido(Integer idPostCurtido);
    Curtida findByIdUsuarioCurtiuAndIdPostCurtido(Integer idUsuarioCurtiu, Integer idPostCurtido);
}
