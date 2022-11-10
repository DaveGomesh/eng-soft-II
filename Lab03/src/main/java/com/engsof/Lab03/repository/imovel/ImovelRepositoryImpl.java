package com.engsof.Lab03.repository.imovel;

import java.util.List;

import com.engsof.Lab03.enumerate.TipoImovel;
import com.engsof.Lab03.model.Imovel;
import com.engsof.Lab03.model.QImovel;
import com.engsof.Lab03.model.QLocacao;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ImovelRepositoryImpl implements ImovelRepositoryQuery {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Imovel> buscarIndisponiveis() {

        QLocacao qLocacao = QLocacao.locacao;

        JPAQuery<Imovel> query = (jpaQueryFactory
            .select(qLocacao.imovel).from(qLocacao)
            .where(qLocacao.ativo.isTrue())
        );

        return query.fetch();
    }

    @Override
    public List<Imovel> buscarDisponiveisPorBairroETipo(String bairro, TipoImovel tipoImovel) {

        QImovel qImovel = QImovel.imovel;

        JPAQuery<Imovel> query = (jpaQueryFactory
            .selectFrom(qImovel)
            .where(qImovel.tipoImovel.eq(tipoImovel))
            .where(qImovel.notIn(buscarIndisponiveis()))
        );

        return query.fetch();
    }
    
    @Override
    public List<Imovel> buscarDisponiveisPorPreco(Double preco) {

        QImovel qImovel = QImovel.imovel;
    
        JPAQuery<Imovel> query = (jpaQueryFactory
            .selectFrom(qImovel)
            .where(qImovel.valorAluguelSugerido.loe(preco))
            .where(qImovel.notIn(buscarIndisponiveis()))
        );
    
        return query.fetch();
    }
    
}
