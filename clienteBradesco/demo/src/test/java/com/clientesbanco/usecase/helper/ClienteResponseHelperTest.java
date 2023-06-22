package com.clientesbanco.usecase.helper;

import com.clientesbanco.domain.Cliente;
import com.clientesbanco.domain.Endereco;
import com.clientesbanco.repository.ClientesRepository;
import com.clientesbanco.web.response.ClienteResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;


class ClienteResponseHelperTest {
    @Mock
    private ClientesRepository clientesRepository;

    @BeforeEach
    public void init() {
        Cliente cliente = new Cliente();
        cliente.setEndereco(new Endereco("rua 10", "234", "campinas", "SP"));
        cliente.setCpf("222.222.222-10");
        cliente.setId("12345");
        cliente.setNome("vanda");

        ClienteResponse response = new ClienteResponse();
        response.setEndereco(new Endereco("rua 10", "234", "campinas", "SP"));
        response.setCpf("222.222.222-10");
        response.setNome("vanda");
    }

    @Test
    void converterResponse() {
        ClienteResponseHelper helper = new ClienteResponseHelper();
        Cliente cliente = new Cliente();
        cliente.setEndereco(new Endereco("rua 10", "234", "campinas", "SP"));
        cliente.setCpf("222.222.222-10");
        cliente.setId("12345");
        cliente.setNome("vanda");

        ClienteResponse response = new ClienteResponse();
        response.setEndereco(new Endereco("rua 10", "234", "campinas", "SP"));
        response.setCpf("222.222.222-10");
        response.setNome("vanda");

        helper.converterResponse(cliente);

    }
}