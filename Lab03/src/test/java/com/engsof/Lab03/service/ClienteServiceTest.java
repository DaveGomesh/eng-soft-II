package com.engsof.Lab03.service;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
public class ClienteServiceTest {

    // @Autowired
    // private ClienteService clienteService;

    // @Test
    // void deveSalvarCliente(){

    //     Cliente cliente = Cliente.builder().nome("Ana").cpf("321").build();
    //     cliente = clienteService.salvar(cliente);
        
    //     assertNotNull(cliente);
    // }
    
    // @Test
    // void deveBuscarTodosOsClientes(){

    //     List<Cliente> clientesParaSalvar = Arrays.asList(
    //         Cliente.builder().nome("David").cpf("123").build(),
    //         Cliente.builder().nome("Ana").cpf("321").build(),
    //         Cliente.builder().nome("João").cpf("789").build()
    //     );

    //     clientesParaSalvar.forEach(clienteService::salvar);

    //     List<Cliente> clientes = clienteService.buscarTodos();
        
    //     assertEquals(clientesParaSalvar.size(), clientes.size());

    //     clientes.forEach(cliente -> {
    //         assertTrue(clientes.contains(cliente));
    //     });
    // }

    // @Test
    // void deverBuscarPorId(){

    //     Cliente clienteSalvo = clienteService.salvar(
    //         Cliente.builder().nome("David").cpf("123").build()
    //     );
        
    //     clienteService.salvar(
    //         Cliente.builder().nome("Ana").cpf("321").build()
    //     );

    //     assertThrows(NoSuchElementException.class, () -> {
    //         clienteService.buscarPorId(99);
    //     });

    //     Cliente cliente = clienteService.buscarPorId(clienteSalvo.getIdCliente());
    //     assertNotNull(cliente);
    //     assertEquals(clienteSalvo, cliente);
    // }

    // @Test
    // void deveBuscarPorNome(){
        
    //     List<Cliente> clientesParaSalvar = Arrays.asList(
    //         Cliente.builder().nome("Maria").cpf("123").build(),
    //         Cliente.builder().nome("Mariana").cpf("321").build(),
    //         Cliente.builder().nome("Marie").cpf("432").build()
    //     );
    //     clientesParaSalvar.forEach(clienteService::salvar);

    //     List<Cliente> clientes = clienteService.buscarPorNome("Maria");
    //     assertEquals(2, clientes.size());
        
    //     clientes = clienteService.buscarPorNome("Marie");
    //     assertEquals(1, clientes.size());
        
    //     clientes = clienteService.buscarPorNome("Marta");
    //     assertEquals(0, clientes.size());
    // }

    // @Test
    // void deveAlterarCliente(){

    //     Cliente clienteSalvo = clienteService.salvar(
    //         Cliente.builder().nome("Davi").cpf("322").build()
    //     );

    //     Cliente cliente = clienteService.buscarPorId(clienteSalvo.getIdCliente());
    //     cliente.setNome("David");
    //     cliente.setCpf("321");

    //     Cliente clienteAtualizado = clienteService.atualizar(cliente);
    //     assertEquals(cliente, clienteAtualizado);
    // }

    // @Test
    // void deveExcluirCliente(){
    //     Cliente cliente = clienteService.salvar(
    //         Cliente.builder().nome("Davi").cpf("322").build()
    //     );

    //     clienteService.excluir(cliente);

    //     assertThrows(NoSuchElementException.class, () -> {
    //         clienteService.buscarPorId(cliente.getIdCliente());
    //     });
    // }
}
