package com.engsof.Lab03.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.engsof.Lab03.model.Emprestimo;
import com.engsof.Lab03.model.Usuario;

@Service
public class DevolverLivroService {
    
    public Emprestimo devolverLivros(Emprestimo emprestimo){

        emprestimo.setDataDevolucao(LocalDate.now());

        if(emprestimo.isAtrasado()){
            Usuario usuario = emprestimo.getUsuario();
            usuario.setEmDebito(true);
        }
        
        return emprestimo;
    }
}
