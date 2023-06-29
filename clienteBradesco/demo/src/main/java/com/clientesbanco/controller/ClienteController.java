package com.clientesbanco.controller;

import com.clientesbanco.domain.Cliente;
import com.clientesbanco.web.ClientesServicesImpl;
import com.clientesbanco.web.dto.ContaDTO;
import com.clientesbanco.web.request.ClienteRequest;
import com.clientesbanco.web.request.ContasRequestService;
import com.clientesbanco.web.response.ClienteResponse;
import com.clientesbanco.web.response.ContaClienteResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {
    @Autowired
    ClientesServicesImpl clientesServicesImpl;
    @Autowired
    ContasRequestService contasRequestService;

    @PostMapping(value = "/clienteCadastro", consumes = "application/json", produces = "application/json")
      public  ResponseEntity<ClienteResponse> cadastrar(@RequestBody ClienteRequest request){
         ClienteResponse response =  clientesServicesImpl.cadastrar(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/clienteDelete/{id}")
    public HttpStatus deletar(@NotNull @NotBlank @PathVariable(name = "id")String id){
        clientesServicesImpl.deletar(id);
        return HttpStatus.OK;
    }

    @Valid
    @PutMapping("/clienteAtualizar/{id}")
    public Optional<Cliente> atualizar(@PathVariable(name = "id")String id, @RequestBody Cliente cliente){
       return clientesServicesImpl.atualizar(id, cliente);
    }

    @Valid
    @GetMapping("/buscarTodos")
    public List<Cliente> buscarTodos(){
       return clientesServicesImpl.buscarTodos();
    }

    @GetMapping("/buscarClientePorId/{id}")
    public Optional<Cliente> buscarPorId(@PathVariable(name = "id") String id){
        return clientesServicesImpl.buscarPorId(id);
    }

    @ResponseBody
    @GetMapping(value = "/buscarConta/{contaId}")
    public ContaDTO buscarContaPorId(@PathVariable(name = "contaId") String contaId){
       return clientesServicesImpl.buscarContaPorId(contaId);
    }

    @ResponseBody
    @GetMapping(value = "/converterConta/{contaId}")
    public ResponseEntity<ContaClienteResponse> converterContaPorId(@PathVariable(name = "contaId") String contaId) {
        if (!contaId.equals(null)) {
            ContaClienteResponse conta = clientesServicesImpl.buscarDadosCompletos(contaId);
            return new ResponseEntity<ContaClienteResponse>(conta, HttpStatus.OK);
        } else {
            return new ResponseEntity<ContaClienteResponse>(HttpStatus.BAD_REQUEST);
        }
    }
}