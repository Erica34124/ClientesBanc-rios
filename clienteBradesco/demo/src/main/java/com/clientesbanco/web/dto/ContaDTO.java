package com.clientesbanco.web.dto;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.io.Serializable;
@Service
@Data
public class ContaDTO implements Serializable {
    private static final long serialVerdionUID = 1L;

    private String id;
    private Boolean ativo;
    private String clienteId;
    private String clienteNome;
    private Double saldo;
    private String cartao;
    private Double taxaSaque;
    private Boolean chequeEspecial;
}
