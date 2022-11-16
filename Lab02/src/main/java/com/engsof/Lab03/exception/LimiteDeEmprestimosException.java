package com.engsof.Lab03.exception;

public class LimiteDeEmprestimosException extends RuntimeException {

    public LimiteDeEmprestimosException() {
        super("O usuário já possui três empréstimos!");
    }
    
}
