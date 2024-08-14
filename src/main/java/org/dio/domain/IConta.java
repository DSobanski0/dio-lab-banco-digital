package org.dio.domain;

public interface IConta {

    void sacar(double valor);

    void depositar(double valor);

    void realizarEmprestimo(double valor);

    void imprimirExtrato();
}