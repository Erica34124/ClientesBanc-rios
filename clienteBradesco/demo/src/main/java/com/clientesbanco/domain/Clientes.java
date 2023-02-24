package com.clientesbanco.domain;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;
import java.util.Objects;

public class Clientes {
    private String id;
    private String nome;
    @NotNull
    @NotBlank
    private Cpf cpf;
    private List<Telefone> telefones;
    private Endereco endereco;

    public Clientes(String id, String nome, Cpf cpf, List<Telefone> telefones, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefones = telefones;
        this.endereco = endereco;
    }

    public Clientes() {
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

    @NotNull
    @NotBlank
    public Cpf getCpf() {
        return cpf;
    }

    public void setCpf(Cpf cpf) {
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
        if (!(o instanceof Clientes clientes)) return false;
        return id.equals(clientes.id);
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
