package com.engsof.Lab03.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.engsof.Lab03.model.Cliente;
import com.engsof.Lab03.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    
    @Transactional
    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }
    
}
