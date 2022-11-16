package com.engsof.Lab03.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.engsof.Lab03.model.Emprestimo;
import com.engsof.Lab03.model.Livro;
import com.engsof.Lab03.model.Usuario;

@SpringBootTest
public class DevolverLivroServiceTest {

    @Autowired
    private EmprestarLivroService emprestarLivroService;

    @Autowired
    private DevolverLivroService devolverLivroService;

    private Usuario usuario;
    private Livro livro;
    private Emprestimo emprestimo;

    @BeforeEach
    void setup(){
        usuario = (Usuario.builder().build());
        livro = (Livro.builder().build());
        emprestimo = emprestarLivroService.emprestarLivro(usuario, livro);
    }
    
    @Test
    void deveDevolverAntesDaDataPrevista(){

        devolverLivroService.devolverLivros(emprestimo);
        assertEquals(5, emprestimo.valorEmprestimo());
        
    }
    
    @Test
    void deveDevolverNaDataPrevista(){
        Assumptions.assumingThat(
            LocalDate.now().equals(LocalDate.now().plusDays(7)), () -> {
                devolverLivroService.devolverLivros(emprestimo);
                assertEquals(5, emprestimo.valorEmprestimo());
            }
        );
    }
    
    @Test
    void deveDevolverUmDiaAposADataPrevista(){
        Assumptions.assumingThat(
            LocalDate.now().equals(LocalDate.now().plusDays(8)), () -> {
                devolverLivroService.devolverLivros(emprestimo);
                assertEquals(5.4, emprestimo.valorEmprestimo());
            }
        );
    }
    
    @Test
    void deveDevolver30DiasAposADataPrevista(){
        Assumptions.assumingThat(
            LocalDate.now().equals(LocalDate.now().plusDays(37)), () -> {
                devolverLivroService.devolverLivros(emprestimo);
                assertEquals(17, emprestimo.valorEmprestimo());
            }
        );
    }

}
