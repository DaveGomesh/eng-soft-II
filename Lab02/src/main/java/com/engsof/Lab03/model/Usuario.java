package com.engsof.Lab03.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Usuario {
    
    private String nome;
    private String matricula;
    private Boolean emDebito;

    @Builder.Default
    private List<Emprestimo> historico = new ArrayList<>();
    
    public void adicionarEmprestimoNoHistorico(Emprestimo emprestimo){
        historico.add(emprestimo);
    }
}
