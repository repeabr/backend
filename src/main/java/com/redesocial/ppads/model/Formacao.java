package com.redesocial.ppads.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Formacao {
    private String nivelDeFormacao;
    private String localDeFormacao;
}
