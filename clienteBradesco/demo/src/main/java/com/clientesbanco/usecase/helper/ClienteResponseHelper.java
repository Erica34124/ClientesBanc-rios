package com.clientesbanco.usecase.helper;

import com.clientesbanco.domain.Cliente;
import com.clientesbanco.repository.ClientesRepository;
import com.clientesbanco.web.response.ClienteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteResponseHelper {

    @Autowired
    ClientesRepository clientesRepository;

    public ClienteResponse converterResponse(Cliente cliente){

        ClienteResponse response = new ClienteResponse();
        response.setCpf(cliente.getCpf());
        response.setNome(cliente.getNome());
        response.setEndereco(cliente.getEndereco());
        response.setTelefones(cliente.getTelefones());
        return response;
    }
}