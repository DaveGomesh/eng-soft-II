package com.engsof.Lab03.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.engsof.Lab03.enumerate.TipoImovel;
import com.engsof.Lab03.model.Imovel;
import com.engsof.Lab03.repository.ImovelRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImovelService {
    
    private final ImovelRepository imovelRepository;

    @Transactional
    public Imovel salvar(Imovel imovel){
        return imovelRepository.save(imovel);
    }

    public List<Imovel> buscarDisponiveisPorBairroETipo(String bairro, TipoImovel tipoImovel){
        return imovelRepository.buscarDisponiveisPorBairroETipo(bairro, tipoImovel);
    }

    public List<Imovel> buscarDisponiveisPorPreco(Double preco){
        return imovelRepository.buscarDisponiveisPorPreco(preco);
    }

}
