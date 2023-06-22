package com.clientesbanco.web.response;

import com.clientesbanco.domain.Cliente;
import com.clientesbanco.domain.Endereco;
import com.clientesbanco.domain.Telefone;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ContaClienteResponse extends Cliente {
    private String id;
    private String ClienteId;
    private String nome;
    private String cpf;
    private Telefone telefones;
    private Endereco endereco;
    private Boolean ativo;
    private Double saldo;
    private String cartao;
    private Double taxaSaque;
    private Boolean chequeEspecial;

    public ContaClienteResponse() {
    }

    public ContaClienteResponse(String id, String clienteId, String nome, String cpf, Telefone telefones, Endereco endereco, Boolean ativo,
                                Double saldo, String cartao, Double taxaSaque, Boolean chequeEspecial) {
        this.id = id;
        ClienteId = clienteId;
        this.nome = nome;
        this.cpf = cpf;
        this.telefones = telefones;
        this.endereco = endereco;
        this.ativo = ativo;
        this.saldo = saldo;
        this.cartao = cartao;
        this.taxaSaque = taxaSaque;
        this.chequeEspecial = chequeEspecial;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClienteId() {
        return ClienteId;
    }

    public void setClienteId(String clienteId) {
        ClienteId = clienteId;
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

    public Telefone getTelefones() {
        return telefones;
    }

    public void setTelefones(Telefone telefones) {
        this.telefones = telefones;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getCartao() {
        return cartao;
    }

    public void setCartao(String cartao) {
        this.cartao = cartao;
    }

    public Double getTaxaSaque() {
        return taxaSaque;
    }

    public void setTaxaSaque(Double taxaSaque) {
        this.taxaSaque = taxaSaque;
    }

    public Boolean getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(Boolean chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }
}