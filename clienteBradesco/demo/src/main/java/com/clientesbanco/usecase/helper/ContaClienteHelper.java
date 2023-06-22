package com.clientesbanco.usecase.helper;

import com.clientesbanco.domain.Cliente;
import com.clientesbanco.web.dto.ContaDTO;
import com.clientesbanco.web.response.ContaClienteResponse;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;


@Service
public class ContaClienteHelper {
    Logger logger = LogManager.getLogger(this.getClass());
    public ContaClienteResponse conversorCliente(ContaDTO contaDTO, Optional<Cliente> newCliente) {
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

        logger.info("Conversão realizada com sucesso! ");
        return contaResponse;
    }
}