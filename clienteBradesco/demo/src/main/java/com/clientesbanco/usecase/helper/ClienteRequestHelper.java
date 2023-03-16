package com.clientesbanco.usecase.helper;

import com.clientesbanco.domain.Cliente;
import com.clientesbanco.web.request.ClienteRequest;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class ClienteRequestHelper {

    public Cliente converterRequest(ClienteRequest request){
        Cliente cliente = new Cliente();
        cliente.setId(UUID.randomUUID().toString());
        cliente.setNome(request.getNome());
        cliente.setCpf(request.getCpf());
        cliente.setEndereco(request.getEndereco());
        cliente.setTelefones(request.getTelefones());
        return cliente;
    }
}