package com.clientesbanco.web.dto;

import lombok.Builder;
import lombok.Data;


public class ContaDTO {
    private String id;
    private Boolean ativo;
    private String clienteId;
    private String clienteNome;
    private Double saldo;
    private String cartao;
    private Double taxaSaque;
    private Boolean chequeEspecial;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
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
