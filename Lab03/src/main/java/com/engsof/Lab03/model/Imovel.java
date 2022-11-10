package com.engsof.Lab03.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.engsof.Lab03.enumerate.TipoImovel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idImovel;

    @Column(nullable = false)
    private TipoImovel tipoImovel;

    private String endereco;
    private String bairro;
    private String cep;
    private Double metragem;
    private Integer dormitorios;
    private Integer banheiros;
    private Integer suites;
    private Integer vagasGaragem;
    private Double valorAluguelSugerido;
    private String observacoes;
}
