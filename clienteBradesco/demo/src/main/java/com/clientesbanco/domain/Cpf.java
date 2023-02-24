package com.clientesbanco.domain;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

@NotNull
@NotBlank
public class Cpf {

    private String numero;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
