package com.engsof.Lab03.exception;

public class LivroEmprestadoException extends RuntimeException {

    public LivroEmprestadoException() {
        super("Livro já emprestado!");
    }
    
}
