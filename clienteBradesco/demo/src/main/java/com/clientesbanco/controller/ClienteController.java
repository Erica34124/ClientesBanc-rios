package com.clientesbanco.controller;

import com.clientesbanco.domain.Cliente;
import com.clientesbanco.web.ClientesServices;
import com.clientesbanco.web.dto.ContaDTO;
import com.clientesbanco.web.request.ContasRequestService;
import com.clientesbanco.web.response.ContaClienteResponse;
import jakarta.validation.Valid;
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
    ClientesServices clientesServices;
    @Autowired
    ContasRequestService contasRequestService;

    @PostMapping("/clienteCadastro")
      public Cliente cadastrar(@RequestBody Cliente cliente){
        return clientesServices.cadastrar(cliente);
    }

    @DeleteMapping("/clienteDelete/{id}")
    public void deletar(@PathVariable(name = "id")String id){
        clientesServices.deletar(id);
    }

    @Valid
    @PutMapping("/clienteAtualizar/{id}")
    public Optional<Cliente> atualizar(@PathVariable(name = "id")String id, @RequestBody Cliente cliente){
       return clientesServices.atualizar(id, cliente);
    }

    @Valid
    @GetMapping("/buscarTodos")
    public List<Cliente> buscarTodos(){
       return clientesServices.buscarTodos();
    }
    @GetMapping("/buscarClientePorId/{id}")
    public Optional<Cliente> buscarPorId(@PathVariable(name = "id") String id){
        return clientesServices.buscarPorId(id);
    }

    @ResponseBody
    @Valid
    @GetMapping(value = "/buscarConta/{contaId}")
    public ResponseEntity<ContaDTO> buscarContaPorId(@PathVariable(name = "contaId") String contaId){
        ContaDTO contaDTO = contasRequestService.consultaConta(contaId);
        return new ResponseEntity<ContaDTO>(contaDTO, HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping(value = "/converterConta/{contaId}")
    public ResponseEntity<ContaClienteResponse> converterContaPorId(@PathVariable(name = "contaId") String contaId){
        ContaClienteResponse conta = clientesServices.buscarDadosCompletos(contaId);
        return new ResponseEntity<ContaClienteResponse>(conta, HttpStatus.OK);
    }

    @PutMapping("/validarDuplicidadeCpf/{cpf}")
    public HttpStatus validarDuplicidadeDeCpf(@PathVariable(name = "cpf")String cpf){
        return clientesServices.verificarDuplicidadeDeCpf(cpf);
    }
}
