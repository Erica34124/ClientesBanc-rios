package com.clientesbanco.web;

import com.clientesbanco.domain.Cliente;
import com.clientesbanco.repository.ClientesRepository;
import com.clientesbanco.usecase.helper.ClienteRequestHelper;
import com.clientesbanco.usecase.helper.ClienteResponseHelper;
import com.clientesbanco.usecase.helper.ContaClienteHelper;
import com.clientesbanco.web.dto.ContaDTO;
import com.clientesbanco.web.request.ClienteRequest;
import com.clientesbanco.web.request.ContasRequestService;
import com.clientesbanco.web.response.ClienteResponse;
import com.clientesbanco.web.response.ContaClienteResponse;
import mocks.ConfigMock;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


import static mocks.Mocks.clienteResponseWithAllFields;
import static mocks.Mocks.contaClienteResponseWithAllFields;
import static mocks.Mocks.clientWithAllFields;
import static mocks.Mocks.clientWithCpfEmpty;
import static mocks.Mocks.clienteRequestWithAllFields;
import static mocks.Mocks.contaDTOWithAllFields;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientesServicesImplTest extends ConfigMock {
    @Mock
    private ClientesRepository repository;
    @Mock
    private ContaClienteHelper contaClienteHelper;
    @Mock
    private ClienteRequestHelper clienteRequestHelper;
    @Mock
    private ClienteResponseHelper clienteResponseHelper;
    @Mock
    private ContasRequestService contasRequestService;

    @InjectMocks
    private ClientesServicesImpl clientesServices;

    @Test
    void shoudCadastrarWithSucess() {
        //Arrage
        String cpf = clientWithCpfEmpty().getCpf();
        ClienteRequest clienteRequest = clienteRequestWithAllFields();
        ClienteResponse clienteResponse = clienteResponseWithAllFields();
        when(repository.findByCpf(clienteRequest.getCpf())).thenReturn(Optional.empty());
        //Act
        clientesServices.cadastrar(clienteRequest);
        //Assert
        Assert.assertEquals(clienteResponse.getCpf(), clienteRequest.getCpf());
        Assert.assertEquals(clienteResponse.getNome(), clienteRequest.getNome());
    }

    @Test
    void shoudCadastrarWithFail() {
        //Arrage
        String cpf = clientWithAllFields().getCpf();
        Cliente cliente = clientWithAllFields();
        ClienteRequest clienteRequest = clienteRequestWithAllFields();
        when(repository.findByCpf(cpf)).thenReturn(Optional.of(cliente));
        //Assert
        Assert.assertThrows(ResponseStatusException.class, () -> clientesServices.cadastrar(clienteRequest));
    }

    @Test
    void shoudDeletaWithSucess() {
        //Arrange
        Cliente cliente = clientWithAllFields();
        when(repository.findById(cliente.getId())).thenReturn(Optional.of(cliente));
        //Act
        clientesServices.deletar(cliente.getId());
        //Assert
        Assertions.assertDoesNotThrow(()-> clientesServices.deletar(cliente.getId()),"Cliente deletado com sucessso!" );
//        Mockito.verify(repository).deleteById(cliente.getId());
    }

    @ParameterizedTest
    @MethodSource("invalidCpfParameters")
    void deletarWithFail(String id) {
        Assert.assertThrows(ResponseStatusException.class, () -> clientesServices.deletar(id));
    }

    @Test
    void atualizar() {
        //Arrange
        Cliente cliente = clientWithAllFields();
        //Act
        when(repository.findById(cliente.getId())).thenReturn(Optional.of(cliente));
        when(repository.save(cliente)).thenReturn((cliente));

        //Assert
        clientesServices.atualizar(cliente.getId(), cliente);
    }

    @ParameterizedTest
    @MethodSource("invalidCpfParameters")
    void atualizarWithFail(String id) {
        //Arrange
        Cliente cliente = clientWithAllFields();

        Assert.assertThrows(ResponseStatusException.class, () -> clientesServices.atualizar(id, cliente));

    }

    @Test
    void buscarTodos() {
        //Arrange
        //Arrange
        Cliente cliente = clientWithAllFields();

        List<Cliente> listaCliente = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            listaCliente.add(cliente);
        }

        //Act
        Mockito.when(repository.findAll()).thenReturn(listaCliente);
        //Assert
        clientesServices.buscarTodos();
    }

    @Test
    void shoudBuscarPorId() {
        //Arrange
        Cliente cliente = clientWithAllFields();

        //Act
        when(repository.findById(any())).thenReturn(Optional.of(cliente));

        //Assert
        clientesServices.buscarPorId(any());

    }

    @ParameterizedTest
    @MethodSource("invalidCpfParameters")
    void shoudBuscarPorIdWithFail(String id) {
        //Assert
        Assert.assertThrows(ResponseStatusException.class, () -> clientesServices.buscarPorId(id));
    }

    @Test
    void buscarDadosCompletos() {
        //Arrange
        Cliente cliente = clientWithAllFields();
        ContaDTO conta = contaDTOWithAllFields();
        ContaClienteResponse response = contaClienteResponseWithAllFields();

        //verificar como mockar metodos staticos. mockar rest template.
        MockedStatic<ContasRequestService> contaRequest = mockStatic(ContasRequestService.class);

        //Act
        when(repository.findById(conta.getClienteId())).thenReturn(Optional.of(cliente));

        contaRequest.when(() -> ContasRequestService.consultaConta(any())).thenReturn(conta);

        when(contaClienteHelper.conversorCliente(conta, Optional.of(cliente))).thenReturn(response);

        //Assert
        clientesServices.buscarDadosCompletos(any());
    }

    @Test
    void shoudVerificarDuplicidadeDeCpf() {
        //Arrange
        Cliente cliente = clientWithAllFields();
        //Action
        when(repository.findByCpf(any())).thenReturn(Optional.of(cliente));

        //Assert
        Assert.assertThrows(ResponseStatusException.class, () -> clientesServices.verificarDuplicidadeDeCpf(cliente.getCpf()));
        Mockito.verify(repository).findByCpf(cliente.getCpf());
    }

    @Test
    void shoudVerificarQuandoNaoHaDuplicidadeDeCpf() {
        //Arrange
        Cliente cliente = clientWithAllFields();
        //Action
        when(repository.findByCpf(cliente.getCpf())).thenReturn(Optional.empty());

        //Assert
        clientesServices.verificarDuplicidadeDeCpf(cliente.getCpf());
        Mockito.verify(repository).findByCpf(cliente.getCpf());
    }

    @Test
    void ShoudCpfValidarWithSucess() {
        //Arrange
        String cpfValido = "222.222.222-22";

        //Act
        clientesServices.cpfValidar(cpfValido);
        //Assert
        Assert.assertEquals("222.222.222-22", cpfValido);
    }

    @ParameterizedTest
    @MethodSource("invalidCpfParameters")
    void ShoudCpfValidarWithWrongCpfFail(String cpf) {
        Assert.assertThrows(IllegalArgumentException.class, () -> clientesServices.cpfValidar(cpf));
    }

    private static Stream<String> invalidCpfParameters() {
        return Stream.of(null, "45y498", "");
    }
}