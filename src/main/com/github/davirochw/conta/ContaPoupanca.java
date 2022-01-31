package main.com.github.davirochw.conta;

import main.com.github.davirochw.cliente.Cliente;

public class ContaPoupanca extends Conta {
    private double taxaJuros = 0.01;

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void sacar(double valor) {
        super.saldo -= valor + (valor * taxaJuros);
    }

    public void extrato() {
        System.out.println("=== Extrato - Conta Poupança: ===");
        informacoesExtrato();
    }
}
