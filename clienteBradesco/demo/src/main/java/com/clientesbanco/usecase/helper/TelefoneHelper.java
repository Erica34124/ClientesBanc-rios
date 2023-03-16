package com.clientesbanco.usecase.helper;

import com.clientesbanco.domain.Telefone;
import java.util.List;

public class TelefoneHelper {

    public static List<Telefone>adicionarTelefone(int quantidadeTelParaCadastrar,
                                                  String ddd, String numero){
        List<Telefone> tel = null;
        int  qtd = 0;
        while (quantidadeTelParaCadastrar >= qtd){
            tel.add(new Telefone(ddd, numero));
            qtd ++;
        }
       return tel;
    }
}