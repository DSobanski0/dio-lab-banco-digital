package org.dio.service.impl;

import org.dio.domain.IConta;
import org.dio.service.ContaService;

public class ContaServiceImpl implements ContaService {

    @Override
    public void transferir(double valor, IConta contaOrigem, IConta contaDestino) {
        contaOrigem.sacar(valor);
        contaDestino.depositar(valor);
    }
}
