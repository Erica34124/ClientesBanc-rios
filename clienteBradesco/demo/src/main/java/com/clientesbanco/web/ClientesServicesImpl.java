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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static com.clientesbanco.web.request.ContasRequestService.consultaConta;

@Service
public class ClientesServicesImpl implements ClienteServices {
    @Autowired
    private ClientesRepository repository;
    @Autowired
    private ContaClienteHelper contaClienteHelper;
    @Autowired
    private ClienteRequestHelper clienteRequestHelper;
    @Autowired
    private ClienteResponseHelper clienteResponseHelper;
    @Autowired
    ContasRequestService contasRequestService;
    Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public ClienteResponse cadastrar(@NotNull ClienteRequest request) {
        if (this.verificarDuplicidadeDeCpf(request.getCpf())){
            this.cpfValidar(request.getCpf());
            Cliente c = clienteRequestHelper.converterRequest(request);
            c = repository.save(c);
            logger.info("Cliente cadastrado com sucessso! ");
            return clienteResponseHelper.converterResponse(c);
        }else {
            throw new ResponseStatusException
                    (HttpStatus.FORBIDDEN, "CPF já cadastrado no sistema");
        }
    }

    @Override
    public void deletar(String id) {
        Optional<Cliente> cliente = repository.findById(id);
        if (cliente.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new ResponseStatusException
                    (HttpStatus.NOT_FOUND, "Cliente não encontrado");
        }
    }

    @Override
    public Optional<Cliente> atualizar(String id, Cliente clientes) {
        Optional<Cliente> cliente = repository.findById(id);
        if (cliente.isPresent()) {
            cliente.get().setNome(clientes.getNome());
            cliente.get().setEndereco(clientes.getEndereco());
            cliente.get().setCpf(clientes.getCpf());
            logger.info("Cliente atualizado com sucessso! ");
            return Optional.of(repository.save(cliente.get()));
        }
        throw new ResponseStatusException
                (HttpStatus.NOT_FOUND, "Cliente não encontrado");

    }

    @Override
    public List<Cliente> buscarTodos() {
        List<Cliente> todosClientes = repository.findAll();
        return todosClientes;
    }

    @Override
    public Optional<Cliente> buscarPorId(String id) {
        Optional<Cliente> cliente = repository.findById(id);
        if (cliente.isPresent()) {
            return repository.findById(id);
        } else {
            throw new ResponseStatusException
                    (HttpStatus.NOT_FOUND, "Cliente não encontrado");
        }
    }

    @Override
    public ContaClienteResponse buscarDadosCompletos(String contaId) {
        ContaDTO contaDTO = consultaConta(contaId);
        Optional<Cliente> cliente = repository.findById(contaDTO.getClienteId());
        if (cliente.isPresent()) {
            return contaClienteHelper.conversorCliente(contaDTO, cliente);
        } else {
            throw new ResponseStatusException
                    (HttpStatus.NOT_FOUND, "Conversão incorreta ");
        }
    }

    public Boolean verificarDuplicidadeDeCpf(String cpf) {
        Optional<Cliente> cpfBanco = repository.findByCpf(cpf);
        if (cpfBanco.isPresent()) {
            throw new ResponseStatusException
                    (HttpStatus.FORBIDDEN, "CPF já cadastrado");

        } else {
            logger.info("Cliente não consta em banco de dados! ");
        }
        return true;
    }

    public ContaDTO buscarContaPorId(String id){
        ContaDTO conta = consultaConta(id);
        return conta;
    }

    public String cpfValidar(String cpf) {

        if (cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw new IllegalArgumentException("Cpf inváldo! ");
        }
        return cpf;
    }
}