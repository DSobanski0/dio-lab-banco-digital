package org.dio.domain;

import lombok.Getter;

@Getter
public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Banco banco;
    protected Cliente cliente;

    public Conta(Banco banco, Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.banco = banco;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    public void realizarEmprestimo(double valor) {
        if (validarEmprestimo(valor)) {
            this.saldo += valor;
            System.out.printf("Empréstimo de $%.2f realizado!%n", valor);
            return;
        }
        System.out.printf("Empréstimo não realizado! Valor de $%.2f acima do permitido%n", valor);
    }

    private boolean validarEmprestimo(double valor) {
        // Empréstimo permitido somente se saldo for maior que 75% do valor solicitado
        return saldo > valor * 0.75;
    }

    protected void imprimirInfosComuns() {
        System.out.printf("Banco: %s%n", this.getBanco().getNome());
        System.out.printf("Titular: %s%n", this.cliente.getNome());
        System.out.printf("Agencia: %d%n", this.agencia);
        System.out.printf("Numero: %d%n", this.numero);
        System.out.printf("Saldo: %.2f%n", this.saldo);
    }
}