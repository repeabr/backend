package com.redesocial.ppads.entity;

import com.redesocial.ppads.model.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pessoa {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;

    private String email;
    private String senha;

    private Curriculo curriculo;
    private Formacao formacao;
    private InfoAdicionais infos;

    private String interesses;

    private Trabalho trabalho;
}
