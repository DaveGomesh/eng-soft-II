package com.engsof.Lab03.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Livro {

    private String autor;
    private String titulo;

    @Builder.Default
    private Boolean emprestado = false;
    
    @Builder.Default
    private Boolean reservado = false;
    
    @Builder.Default
    private List<Emprestimo> historico = new ArrayList<>();

    public Boolean emprestar(){
        setEmprestado(true);
        return emprestado;
    }

    public List<Emprestimo> buscarEmprestimoPorUsuario(Usuario usuario){
        
        List<Emprestimo> emprestimoPorUsuario = (historico.stream()
            .filter(emprestimo -> emprestimo.getUsuario().equals(usuario))
            .collect(Collectors.toList())
        );

        return emprestimoPorUsuario;
    }
}
