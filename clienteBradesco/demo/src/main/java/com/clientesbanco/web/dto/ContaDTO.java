package com.clientesbanco.web.dto;

import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class ContaDTO {
    private String id;
    private Boolean ativo;
    private String clienteId;
    private String clienteNome;
    private Double saldo;
    private String cartao;
    private Double taxaSaque;
    private Boolean chequeEspecial;
}