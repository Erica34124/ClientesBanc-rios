package com.clientesbanco.web;

import com.clientesbanco.domain.Cliente;
import com.clientesbanco.web.request.ClienteRequest;
import com.clientesbanco.web.response.ClienteResponse;
import com.clientesbanco.web.response.ContaClienteResponse;

import java.util.List;
import java.util.Optional;

public interface ClienteServices {
    ClienteResponse cadastrar (ClienteRequest cliente);
    void deletar(String id);
    Optional<Cliente> atualizar(String id, Cliente cliente);
    List<Cliente> buscarTodos();
    Optional<Cliente> buscarPorId(String id);
    ContaClienteResponse buscarDadosCompletos(String contaId);
}
