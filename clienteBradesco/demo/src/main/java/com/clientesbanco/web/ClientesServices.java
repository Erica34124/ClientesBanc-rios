package com.clientesbanco.web;

import com.clientesbanco.domain.Clientes;
import com.clientesbanco.repository.ClientesRepository;
import com.clientesbanco.usecase.helper.ContaClienteHelper;
import com.clientesbanco.web.dto.ContaDTO;
import com.clientesbanco.web.response.ContaClienteResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.clientesbanco.web.request.ContasRequestService.consultaConta;

@Service
@Validated
public class ClientesServices implements ClienteDatabaseOperations {
    @Autowired
    ClientesRepository repository;
    @Autowired
    ContaClienteHelper contaClienteHelper;
    Logger logger = LogManager.getLogger(this.getClass());

    public ClientesServices(ClientesRepository repository) {
        this.repository = repository;
    }

    @Override
    public Clientes cadastrar(Clientes cliente) {
        cliente.setId(UUID.randomUUID().toString());
        return repository.save(cliente);
    }

    @Override
    public void deletar(String id) {
        Optional<Clientes> cliente = repository.findById(id);
        if (cliente.isPresent()) {
            repository.deleteById(id);
            logger.info("Cliente deletado com sucessso! ");
        } else {
            throw new ResponseStatusException
                    (HttpStatus.NOT_FOUND, "Cliente não encontrado");
        }
    }

    @Override
    public Optional<Clientes> atualizar(String id, Clientes clientes) {
        Optional<Clientes> cliente = repository.findById(id);
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
    public List<Clientes> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<Clientes> buscarPorId(String id) {
        Optional<Clientes> cliente = repository.findById(id);
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
        Optional<Clientes> clientes = repository.findById(contaDTO.getClienteId());
        if (clientes.isPresent()) {
          return contaClienteHelper.conversorCliente(contaId , clientes);
        }else{
            throw new ResponseStatusException
                    (HttpStatus.NOT_FOUND, "Conversão incorreta ");
        }
    }
}
