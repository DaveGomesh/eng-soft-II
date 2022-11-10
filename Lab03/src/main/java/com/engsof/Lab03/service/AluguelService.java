package com.engsof.Lab03.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.engsof.Lab03.model.Aluguel;
import com.engsof.Lab03.repository.AluguelRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AluguelService {
    
    private final AluguelRepository aluguelRepository;

    @Transactional
    public Aluguel salvar(Aluguel aluguel){
        return aluguelRepository.save(aluguel);
    }
    
}
