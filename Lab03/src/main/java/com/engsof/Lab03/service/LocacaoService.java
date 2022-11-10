package com.engsof.Lab03.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.engsof.Lab03.model.Locacao;
import com.engsof.Lab03.repository.LocacaoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LocacaoService {
    
    private final LocacaoRepository locacaoRepository;

    @Transactional
    public Locacao salvar(Locacao locacao){
        return locacaoRepository.save(locacao);
    }
    
}
