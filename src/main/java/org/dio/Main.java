package org.dio;

import org.dio.domain.*;
import org.dio.service.ContaService;
import org.dio.service.impl.ContaServiceImpl;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco(341, "Banco Itaú");
        Cliente cliente = new Cliente();
        cliente.setNome("Daniel");

        Conta cc = new ContaCorrente(banco, cliente);
        Conta poupanca = new ContaPoupanca(banco, cliente);
        ContaService contaService = new ContaServiceImpl();

        cc.depositar(100);
        contaService.transferir(100, cc, poupanca);

        poupanca.realizarEmprestimo(130);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}