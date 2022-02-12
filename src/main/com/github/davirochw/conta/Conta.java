package main.com.github.davirochw.conta;

import main.com.github.davirochw.cliente.Cliente;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIA = 1;
    private final int agencia;
    private final int numero;
    protected double saldo;
    protected Cliente cliente;

    protected Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIA++;
        this.cliente = cliente;
    }

    public double saldo() {
        return saldo;
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void sacar(double valor) {
        this.saldo -= valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void informacoesExtrato() {
        System.out.printf("Titular: %s\n" +
                        "CPF: %s\n" +
                        "Agencia: %d\n" +
                        "Numero: %d\n" +
                        "Saldo: %.2f\n",
                this.cliente.getNome(), this.cliente.getCpf(), this.agencia, this.numero, this.saldo);
    }
}
