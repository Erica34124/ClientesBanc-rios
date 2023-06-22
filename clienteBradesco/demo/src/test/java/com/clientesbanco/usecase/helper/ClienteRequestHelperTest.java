package com.clientesbanco.usecase.helper;

import com.clientesbanco.domain.Endereco;
import com.clientesbanco.domain.Telefone;
import com.clientesbanco.web.request.ClienteRequest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ClienteRequestHelperTest {
    @Test
    void shoudConverterRequestWithSucess(){
        ClienteRequest clienteRequest = new ClienteRequest(
                "erica", "555.555.555-22", new Telefone("19","19999999999"),
                new Endereco("rua 10", "234", "campinas", "SP"));

        ClienteRequestHelper clienteRequestHelper = new ClienteRequestHelper();

      clienteRequestHelper.converterRequest(clienteRequest);
    }

    @Test
    void shoudConverterRequestWithFail(){
        //Arrange
        ClienteRequest clienteRequest = new ClienteRequest(
                "", "", new Telefone("19","19999999999"),
                new Endereco("rua 10", "234", "campinas", "SP"));

        //Action
        ClienteRequestHelper clienteRequestHelper = new ClienteRequestHelper();

        //Assert
         clienteRequestHelper.converterRequest(clienteRequest);
    }

    @Test
    void shoudConverterRequestWithNull(){
        //Arrange
        ClienteRequest clienteRequest = new ClienteRequest(
                "erica", "555.555.555-22", new Telefone("19","19999999999"),
                new Endereco("rua 10", "234", "campinas", "SP"));

        //Action
        ClienteRequestHelper clienteRequestHelper = new ClienteRequestHelper();

        //Assert
        Assert.assertThrows(NullPointerException.class, ()-> clienteRequestHelper.converterRequest(null));

    }
}