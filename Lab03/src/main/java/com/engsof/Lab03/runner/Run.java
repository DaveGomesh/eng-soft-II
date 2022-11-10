package com.engsof.Lab03.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class Run implements CommandLineRunner {

     @Override
    public void run(String... args) throws Exception {

        // System.out.println("\n==============================================");
        // System.out.println("BEGIN\n");
        
        // // Cliente cliente = Cliente.builder().nome("David").cpf("123").build();
        // // clienteRepository.save(cliente);

        // System.out.println("\nEND");
        // System.out.println("==============================================\n");
    }
    
}
