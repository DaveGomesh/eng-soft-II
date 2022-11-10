package com.engsof.Lab03.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.engsof.Lab03.enumerate.TipoImovel;
import com.engsof.Lab03.model.Cliente;
import com.engsof.Lab03.model.Imovel;
import com.engsof.Lab03.model.Locacao;

@Transactional
@SpringBootTest
public class ImovelServiceTest {

    @Autowired
    private ImovelService imovelService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private LocacaoService locacaoService;
    
    @Test
    void deveBuscarDisponiveisPorBairroETipo(){

        Imovel imovel = Imovel.builder().tipoImovel(TipoImovel.APARTAMENTO).bairro("Cohab").build();
        imovelService.salvar(imovel);

        Cliente cliente = Cliente.builder().nome("João").telefone1("123").build();
        clienteService.salvar(cliente);

        Locacao locacao = Locacao.builder().cliente(cliente).imovel(imovel).ativo(false).build();
        locacaoService.salvar(locacao);

        List<Imovel> imoveisDisponiveis = imovelService.buscarDisponiveisPorBairroETipo(
            "Cohab", TipoImovel.APARTAMENTO
        );
        
        assertEquals(1, imoveisDisponiveis.size());
    }

    @Test
    void deveBuscarDisponiveisPorValor(){

        Imovel imovel1 = Imovel.builder().valorAluguelSugerido(200d).tipoImovel(TipoImovel.APARTAMENTO).build();
        Imovel imovel2 = Imovel.builder().valorAluguelSugerido(150d).tipoImovel(TipoImovel.APARTAMENTO).build();
        imovelService.salvar(imovel1);
        imovelService.salvar(imovel2);

        Cliente cliente1 = Cliente.builder().nome("João").telefone1("123").build();
        Cliente cliente2 = Cliente.builder().nome("Carla").telefone1("123").build();
        clienteService.salvar(cliente1);
        clienteService.salvar(cliente2);

        Locacao locacao1 = Locacao.builder().cliente(cliente1).imovel(imovel1).ativo(false).build();
        Locacao locacao2 = Locacao.builder().cliente(cliente2).imovel(imovel2).ativo(false).build();
        locacaoService.salvar(locacao1);
        locacaoService.salvar(locacao2);

        List<Imovel> imoveisDisponiveis = imovelService.buscarDisponiveisPorPreco(180d);

        assertEquals(1, imoveisDisponiveis.size());
    }
    
}
