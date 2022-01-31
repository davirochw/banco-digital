package main.com.github.davirochw.conta;

public interface IConta {
    void depositar(double valor);
    void sacar(double valor);
    void transferir(double valor, Conta conta);
    void extrato();
}
