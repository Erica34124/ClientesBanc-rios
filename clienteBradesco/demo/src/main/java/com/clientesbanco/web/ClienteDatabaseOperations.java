package com.clientesbanco.web;

import com.clientesbanco.domain.Clientes;
import com.clientesbanco.web.response.ContaClienteResponse;

import java.util.List;
import java.util.Optional;

public interface ClienteDatabaseOperations {
    Clientes cadastrar (Clientes clientes);
    void deletar(String id);
    Optional<Clientes> atualizar(String id, Clientes clientes);
    List<Clientes> buscarTodos();
    Optional<Clientes> buscarPorId(String id);
    ContaClienteResponse buscarDadosCompletos(String contaId);
}
