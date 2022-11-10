package com.engsof.Lab03.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLocacao;

    @ManyToOne
    @JoinColumn(name = "fk_locacao", nullable = false)
    private Locacao locacao;

    private LocalDate dataVencimento;
    private LocalDate dataPagamento;
    private Double valorPago;
}
