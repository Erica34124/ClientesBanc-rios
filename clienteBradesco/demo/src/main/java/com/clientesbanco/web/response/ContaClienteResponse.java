package com.clientesbanco.web.response;

import com.clientesbanco.domain.Cpf;
import com.clientesbanco.domain.Endereco;
import com.clientesbanco.domain.Telefone;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Builder
@Data
public class ContaClienteResponse {
    private String id;
    private String ClienteId;
    private String nome;
    private Cpf cpf;
    private List<Telefone> telefones;
    private Endereco endereco;
    private Boolean ativo;
    private Double saldo;
    private String cartao;
    private Double taxaSaque;
    private Boolean chequeEspecial;

    public ContaClienteResponse(String id, String clienteId, String nome, Cpf cpf, List<Telefone> telefones, Endereco endereco, Boolean ativo, Double saldo, String cartao, Double taxaSaque, Boolean chequeEspecial) {
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
}
