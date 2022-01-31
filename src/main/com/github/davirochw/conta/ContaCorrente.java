package main.com.github.davirochw.conta;

import main.com.github.davirochw.cliente.Cliente;

public class ContaCorrente  extends Conta {
    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    public void extrato() {
        System.out.println("=== Extrato - Conta Corrente: ===");
        informacoesExtrato();
    }
}
