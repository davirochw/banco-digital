package main.com.github.davirochw.cadastro;

import javax.swing.*;

import main.com.github.davirochw.cliente.Cliente;
import main.com.github.davirochw.conta.Conta;
import main.com.github.davirochw.conta.ContaCorrente;
import main.com.github.davirochw.conta.ContaPoupanca;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class CadastroDeContas {
    public static void main(String[] args) {
        int tipo;
        double valor;

        Conta conta = null;
        Cliente cliente;

        List<Conta> contas = new ArrayList<>();

        while (true) {
            String nome = JOptionPane.showInputDialog("Digite seu nome: ");
            String cpf = JOptionPane.showInputDialog("Digite seu CPF: ");

            cliente = new Cliente(nome, cpf);

            try {
                tipo = Integer.parseInt(JOptionPane.showInputDialog("Digite o tipo de conta: 1 - Conta Corrente, 2 - Conta Poupança: "));
                if (tipo == 1) {
                    conta = new ContaCorrente(cliente);
                } else if (tipo == 2) {
                    conta = new ContaPoupanca(cliente);
                }
            } catch (InputMismatchException e) {
                JOptionPane.showMessageDialog(null, "Digite um número válido!");
                break;
            }

            valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor que deseja depositar: "));
            conta.depositar(valor);

            valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor que deseja sacar: "));
            conta.sacar(valor);
            if (conta.saldo() < 0) {
                JOptionPane.showMessageDialog(null, "Saldo insuficiente! O saldo da conta é:\n" + String.format("%.2f", conta.saldo() + valor) + " reais");
            }

            contas.add(conta);

            if (contas.size() >= 2) {
                String desejaTransferir = JOptionPane.showInputDialog("Deseja fazer transferência? (S/N)");
                if (desejaTransferir.equals("S")) {
                    valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor que deseja transferir: "));
                    int contaOrigem = Integer.parseInt(JOptionPane.showInputDialog("Digite a conta de origem: "));
                    int contaDestino = Integer.parseInt(JOptionPane.showInputDialog("Digite a conta de destino: "));
                    try {
                        contas.get(contaOrigem - 1).transferir(valor, contas.get(contaDestino - 1));
                    } catch (IndexOutOfBoundsException e) {
                        JOptionPane.showMessageDialog(null, "Conta de origem ou destino inválida!");
                    }
                }
            }

            if (JOptionPane.showInputDialog("Deseja criar outra conta? (S/N)").equals("N")) {
                break;
            }
        }

        try {
            for (Conta c : contas) c.extrato();
        } catch (NullPointerException e) {
            System.out.println("Nenhuma conta criada!");
        }
    }
}
