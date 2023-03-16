package com.clientesbanco.web.response;
import com.clientesbanco.domain.Endereco;
import com.clientesbanco.domain.Telefone;

import java.util.List;

public class ClienteResponse{
    private String nome;
    private String cpf;
    private Endereco endereco;
    private List<Telefone> telefones;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
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

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
}