package com.clientesbanco.domain;

import java.util.List;
import java.util.Objects;

public class Cliente {
    private String id;
    private String nome;
    private String cpf;
    private List<Telefone> telefones;
    private Endereco endereco;

    public Cliente(String id, String nome, String cpf, List<Telefone> telefones, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefones = telefones;
        this.endereco = endereco;
    }

    public Cliente() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;
        return id.equals(cliente.id);
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", telefones=" + telefones +
                ", endereco=" + endereco +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
