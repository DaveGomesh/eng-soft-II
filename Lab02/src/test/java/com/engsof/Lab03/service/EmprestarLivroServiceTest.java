package com.engsof.Lab03.service;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.engsof.Lab03.exception.LimiteDeEmprestimosException;
import com.engsof.Lab03.exception.LivroEmprestadoException;
import com.engsof.Lab03.model.Emprestimo;
import com.engsof.Lab03.model.Livro;
import com.engsof.Lab03.model.Usuario;

@SpringBootTest
public class EmprestarLivroServiceTest {

    @Autowired
    private EmprestarLivroService emprestarLivroService;
    
    @Test
    void deveRealizarEmprestimoParaLivroNaoReservado(){

        Usuario usuario = (Usuario.builder().build());
        Livro livro = (Livro.builder().build());

        Emprestimo emprestimo = emprestarLivroService.emprestarLivro(usuario, livro);

        assertNotNull(emprestimo);
        
        assertFalse(emprestimo.getLivros().isEmpty());
        assertEquals(livro, emprestimo.getLivros().get(0));
        assertTrue(livro.getEmprestado());
    }

    @Test
    void naoDeveRealizarEmprestimoParaLivroReservado(){

        Usuario usuario = (Usuario.builder().build());
        Livro livro = (Livro.builder().reservado(true).build());
        
        assertThrows(LivroEmprestadoException.class, () -> {
            emprestarLivroService.emprestarLivro(usuario, livro);
        });
    }

    @Test
    void deveDefinirADataDeDevolucaoPara7DiasAposOEmprestimo(){

        Usuario usuario = (Usuario.builder().build());
        Livro livro = (Livro.builder().build());

        Emprestimo emprestimo = emprestarLivroService.emprestarLivro(usuario, livro);

        LocalDate dataAtual = LocalDate.now();
        assertEquals(dataAtual.plusDays(7), emprestimo.getDataPrevista());
    }

    @Test
    void deveEmprestarOMesmoLivroParaUsuarioCom1A3EmprestimoMasNaoCom4(){

        Usuario usuario = (Usuario.builder().build());
        Livro livro1 = (Livro.builder().build());
        Livro livro2 = (Livro.builder().build());
        Livro livro3 = (Livro.builder().build());
        Livro livro4 = (Livro.builder().build());

        assertDoesNotThrow(() -> {
            emprestarLivroService.emprestarLivro(usuario, livro1);
            emprestarLivroService.emprestarLivro(usuario, livro2);
            emprestarLivroService.emprestarLivro(usuario, livro3);
        });

        assertThrows(LimiteDeEmprestimosException.class, () -> {
            emprestarLivroService.emprestarLivro(usuario, livro4);
        });
    }
}
