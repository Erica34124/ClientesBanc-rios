package com.clientesbanco.usecase.helper;

import com.clientesbanco.domain.Cliente;
import com.clientesbanco.repository.ClientesRepository;
import com.clientesbanco.web.request.ClienteRequest;
import com.clientesbanco.web.response.ClienteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ClienteResponseHelper {

    @Autowired
    ClientesRepository clientesRepository;

    public ClienteResponse converterResponse(ClienteRequest request){
        Optional<Cliente> repositoryData = clientesRepository.findByCpf(request.getCpf());
        ClienteResponse response = new ClienteResponse();
        response.setCpf(repositoryData.get().getCpf());
        response.setNome(repositoryData.get().getNome());
        response.setEndereco(repositoryData.get().getEndereco());
        response.setTelefones(repositoryData.get().getTelefones());
        return response;
    }
}