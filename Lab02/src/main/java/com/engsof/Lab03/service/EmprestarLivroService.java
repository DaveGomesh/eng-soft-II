package com.engsof.Lab03.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.engsof.Lab03.exception.LimiteDeEmprestimosException;
import com.engsof.Lab03.exception.LivroEmprestadoException;
import com.engsof.Lab03.model.Emprestimo;
import com.engsof.Lab03.model.Livro;
import com.engsof.Lab03.model.Usuario;

@Service
public class EmprestarLivroService {

    public Emprestimo emprestarLivro(Usuario usuario, Livro livro){
        return emprestarLivros(usuario, Arrays.asList(livro));
    }

    public Emprestimo emprestarLivros(Usuario usuario, List<Livro> livros){

        if(temLivroEmprestado(livros)){
            throw new LivroEmprestadoException();
        }

        if(usuarioPossuiTresEmprestimos(usuario)){
            throw new LimiteDeEmprestimosException();
        }

        LocalDate dataAtual = LocalDate.now();

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setUsuario(usuario);
        emprestimo.setLivros(livros);
        emprestimo.setDataEmprestimo(dataAtual);
        emprestimo.setDataPrevista(dataAtual.plusDays(7));

        usuario.adicionarEmprestimoNoHistorico(emprestimo);
        livros.forEach(livro -> livro.setEmprestado(true));

        return emprestimo;
    }

    private Boolean temLivroEmprestado(List<Livro> livros){
        return (livros.stream().anyMatch(
            livro -> livro.getReservado() || livro.getEmprestado()
        ));
    }

    private Boolean usuarioPossuiTresEmprestimos(Usuario usuario){
        return usuario.getHistorico().size() == 3;
    }

}
