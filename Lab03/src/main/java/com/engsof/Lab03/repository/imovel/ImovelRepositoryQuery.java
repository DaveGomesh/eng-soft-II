package com.engsof.Lab03.repository.imovel;

import java.util.List;

import com.engsof.Lab03.enumerate.TipoImovel;
import com.engsof.Lab03.model.Imovel;

public interface ImovelRepositoryQuery {
    
    public List<Imovel> buscarIndisponiveis();
    public List<Imovel> buscarDisponiveisPorBairroETipo(String bairro, TipoImovel tipoImovel);
    public List<Imovel> buscarDisponiveisPorPreco(Double preco);
}
