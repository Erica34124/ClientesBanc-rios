package com.clientesbanco.web.request;

import com.clientesbanco.domain.Endereco;
import com.clientesbanco.domain.Telefone;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;


public class ClienteRequest{
    @NotBlank(message = "Nome é obrigatório! ")
    private String nome;
    @NotBlank
    @CPF(message = "Cpf com onze digitos pontos e traço. Ex: (111.111.111-11)." )
    private String cpf;
    @JsonProperty
    private Endereco endereco;
    private Telefone telefones;

    public ClienteRequest() {
    }

    public ClienteRequest(String nome, String cpf, Telefone telefones, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefones = telefones;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public @NotBlank @CPF(message = "Cpf com onze digitos pontos e traço. Ex: (111.111.111-11).") String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public Telefone getTelefones() {
        return telefones;
    }

    public void setTelefones(Telefone telefones) {
        this.telefones = telefones;
    }


}