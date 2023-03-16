package com.clientesbanco.web.request;

import com.clientesbanco.web.dto.ContaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ContasRequestService {

    public static ContaDTO consultaConta(String contaId) {
        String url = String.format("http://localhost:8089/adm/buscarContaPorId/ %s ", contaId);
        ContaDTO request = new RestTemplate().getForEntity(url, ContaDTO.class).getBody();
        try {
            return request;
        } catch (ResourceAccessException exception) {
            throw new ResponseStatusException
                    (HttpStatus.SERVICE_UNAVAILABLE, "Serviço inativo ");
        }
    }
}