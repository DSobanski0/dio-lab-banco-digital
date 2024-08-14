package org.dio.service;

import org.dio.domain.IConta;

public interface ContaService {

    void transferir(double valor, IConta contaOrigem, IConta contaDestino);
}
