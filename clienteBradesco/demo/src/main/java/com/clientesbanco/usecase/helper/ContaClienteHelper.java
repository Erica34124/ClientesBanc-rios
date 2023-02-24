package com.clientesbanco.usecase.helper;

import com.clientesbanco.domain.Clientes;
import com.clientesbanco.web.dto.ContaDTO;
import com.clientesbanco.web.response.ContaClienteResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.clientesbanco.web.request.ContasRequestService.consultaConta;

@Service
public class ContaClienteHelper {

    public ContaClienteResponse conversorCliente(String contaId, Optional<Clientes> newCliente) {
        ContaDTO contaDTO = consultaConta(contaId);
        ContaClienteResponse contaResponse = ContaClienteResponse.builder()
                .id(contaDTO.getId())
                .cpf(newCliente.get().getCpf())
                .ClienteId(newCliente.get().getId())
                .nome(newCliente.get().getNome())
                .ativo(contaDTO.getAtivo())
                .cartao(contaDTO.getCartao())
                .endereco(newCliente.get().getEndereco())
                .taxaSaque(contaDTO.getTaxaSaque())
                .saldo(contaDTO.getSaldo())
                .chequeEspecial(contaDTO.getChequeEspecial())
                .telefones(newCliente.get().getTelefones())
                .cartao(contaDTO.getCartao())
                .build();

        return contaResponse;
    }
}
