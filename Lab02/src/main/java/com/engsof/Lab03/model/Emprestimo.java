package com.engsof.Lab03.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import lombok.Data;

@Data
public class Emprestimo {

    private final Double VALOR_POR_LIVRO = 5d;
    private final Double VALOR_POR_DIA_ATRASO = 0.4;
    
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevista;
    private LocalDate dataDevolucao;
    private List<Livro> livros;

    public Double valorEmprestimo(){
        return calcularValorEmprestimo();
    }

    public Double calcularValorEmprestimo(){

        Double valorPorLivro = valorPorLivro();
        Double valorAtraso = valorAtraso();

        return valorPorLivro + valorAtraso;
    }

    public Double valorPorLivro(){
        return Double.valueOf(quantLivros() * VALOR_POR_LIVRO);
    }

    public Double valorAtraso(){
        return isAtrasado() ? quantDiasAtraso() * VALOR_POR_DIA_ATRASO : 0d;
    }
    
    public Integer quantLivros(){
        return livros.size();
    }

    public Long quantDiasAtraso(){
        return dataPrevista.until(dataDevolucao, ChronoUnit.DAYS);
    }

    public Boolean isAtrasado(){
        return quantDiasAtraso() > 0;
    }

}
