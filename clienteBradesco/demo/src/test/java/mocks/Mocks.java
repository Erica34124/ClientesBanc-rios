package mocks;

import com.clientesbanco.domain.Cliente;
import com.clientesbanco.domain.Endereco;
import com.clientesbanco.domain.Telefone;
import com.clientesbanco.web.dto.ContaDTO;
import com.clientesbanco.web.request.ClienteRequest;
import com.clientesbanco.web.response.ClienteResponse;
import com.clientesbanco.web.response.ContaClienteResponse;

import java.util.ArrayList;
import java.util.List;

public class Mocks {
    public static Cliente clientWithAllFields() {
        Cliente cliente = new Cliente();
        cliente.setNome("Ana");
        cliente.setId("123456");
        cliente.setCpf("123.456.789-10");
        cliente.setTelefones(new Telefone("19", "99 999-9999"));
        cliente.setEndereco(new Endereco("rua 10", "234", "campinas", "SP"));

        return cliente;
    }

    public static Cliente clientWithCpfEmpty() {
        Cliente cliente = new Cliente();
        cliente.setNome("Ana");
        cliente.setId("123456");
        cliente.setCpf("");
        cliente.setTelefones(new Telefone("19", "99 999-9999"));
        cliente.setEndereco(new Endereco("rua 10", "234", "campinas", "SP"));
        cliente.setNome("Ana");

        return cliente;
    }

    public static ClienteRequest clienteRequestWithAllFields() {
        ClienteRequest clienteRequest = new ClienteRequest();
        clienteRequest.setNome("Ana");
        clienteRequest.setCpf("123.456.789-10");
        clienteRequest.setTelefones(new Telefone("19", "99 999-9999"));
        clienteRequest.setEndereco(new Endereco("rua 10", "234", "campinas", "SP"));
        clienteRequest.setNome("Ana");

        return clienteRequest;
    }

    public static ClienteResponse clienteResponseWithAllFields() {
        ClienteResponse clienteResponse = new ClienteResponse();
        clienteResponse.setNome("Ana");
        clienteResponse.setCpf("123.456.789-10");
        clienteResponse.setTelefones(new Telefone("19", "99 999-9999"));
        clienteResponse.setEndereco(new Endereco("rua 10", "234", "campinas", "SP"));
        clienteResponse.setNome("Ana");

        return clienteResponse;
    }


    public static ContaDTO contaDTOWithAllFields() {
        ContaDTO conta = new ContaDTO();
        conta.setId("5647");
        conta.setSaldo(2000d);
        conta.setAtivo(true);
        conta.setCartao("Master");
        conta.setChequeEspecial(true);
        conta.setClienteNome("Claudia");
        conta.setClienteId("456");
        conta.setTaxaSaque(0.2d);

        return conta;
    }

    public static ContaClienteResponse contaClienteResponseWithAllFields() {
        ContaClienteResponse contaResponse = ContaClienteResponse.builder()
                .id("1234")
                .cpf("555.555.555-55")
                .ClienteId("65444")
                .nome("Elena Martins")
                .ativo(true)
                .cartao("Master")
                .endereco(new Endereco("Gumercindo", "52", "Campinas", "SP"))
                .taxaSaque(0.2d)
                .saldo(5000d)
                .chequeEspecial(true)
                .telefones(new Telefone("19", "99999999999"))
                .cartao("Master")
                .build();

        return contaResponse;
    }

    public static List<Cliente> clientRepositoryWithAllFields() {
        List<Cliente> listaCliente = new ArrayList<>();

        Cliente cliente = new Cliente();
        cliente.setNome("Ana");
        cliente.setId("123456");
        cliente.setCpf("123.456.789-10");
        cliente.setTelefones(new Telefone("19", "99 999-9999"));
        cliente.setEndereco(new Endereco("rua 10", "234", "campinas", "SP"));
        listaCliente.add(cliente);

        Cliente cliente1 = new Cliente();
        cliente.setNome("Fernando");
        cliente.setId("123456");
        cliente.setCpf("123.456.789-11");
        cliente.setTelefones(new Telefone("19", "99 999-9999"));
        cliente.setEndereco(new Endereco("rua 10", "234", "campinas", "SP"));
        cliente.setNome("Ana");
        cliente.setNome("Ana");
        listaCliente.add(cliente1);

        Cliente cliente2 = new Cliente();
        cliente.setNome("Mara");
        cliente.setId("123456");
        cliente.setCpf("123.456.789-12");
        cliente.setTelefones(new Telefone("19", "99 999-9999"));
        cliente.setEndereco(new Endereco("rua 10", "234", "campinas", "SP"));
        cliente.setNome("Ana");
        listaCliente.add(cliente2);

        return listaCliente;
    }
}




