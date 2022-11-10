package com.engsof.Lab03.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Locacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLocacao;

    @ManyToOne
    @JoinColumn(name = "fk_imovel", nullable = false)
    private Imovel imovel;

    @ManyToOne
    @JoinColumn(name = "fk_cliente", nullable = false)
    private Cliente cliente;
    
    private Double valor;
    private Double percentualMulta;
    private LocalDate dataVencimento;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Boolean ativo;
    private String observacoes;
}
