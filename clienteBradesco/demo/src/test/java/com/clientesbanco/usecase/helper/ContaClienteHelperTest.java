package com.clientesbanco.usecase.helper;

import com.clientesbanco.domain.Cliente;
import com.clientesbanco.domain.Endereco;
import com.clientesbanco.domain.Telefone;
import com.clientesbanco.web.dto.ContaDTO;
import com.clientesbanco.web.response.ContaClienteResponse;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.logging.Logger;

import static mocks.Mocks.contaDTOWithAllFields;


class ContaClienteHelperTest {


    Cliente cliente = new Cliente();
    org.apache.logging.log4j.Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
//        logger.info("startup");
//        dto.setClienteId("123");
//        dto.setId("456");
//        dto.setCartao("master");
//        dto.setTaxaSaque(0.2);
//        dto.setChequeEspecial(true);

        cliente.setNome("Claudia");
        cliente.setId("345");
        cliente.setCpf("222.555.666-44");
        cliente.setTelefones(new Telefone("19","19999999999"));
        cliente.setEndereco(new Endereco("rua 10", "234", "campinas", "SP"));

    }

    @AfterEach
    void tearDown() {
        logger.info("teardown");
    }

    @Test
    void conversorCliente() {
        //Arrange
        ContaClienteHelper helper = new ContaClienteHelper();
        ContaDTO dto = contaDTOWithAllFields();

        //Act
        final ContaClienteResponse response = helper.conversorCliente(dto, Optional.of(cliente));

        //Assert
        Assert.assertEquals("345", response.getClienteId());
        Assert.assertEquals("Claudia", response.getNome());
        Assert.assertEquals("222.555.666-44", response.getCpf());
        Assert.assertEquals("master", response.getCartao());
    }
}