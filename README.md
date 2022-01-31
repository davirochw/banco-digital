## Cadastro de conta corrente e poupança

Aplicação feita utilizando princípios da programação orientada a objetos, java swing, arraylist e tratamentos de exceções.

---

> **Cadastro de um novo cliente**

```java
String nome = JOptionPane.showInputDialog("Digite seu nome: ");
String cpf = JOptionPane.showInputDialog("Digite seu CPF: ");

Cliente cliente = new Cliente(nome, cpf);
```
___

> **Cadastro de uma nova conta corrente ou poupança**
```java
try {
    tipo = Integer.parseInt(JOptionPane.showInputDialog(
            "Digite o tipo de conta: " +
            "1 - Conta Corrente, 2 - Conta Poupança: "));
    } catch (InputMismatchException e) {
        JOptionPane.showMessageDialog(null,"Digite um número válido!");
        break;
    }
```

---

> **Depositar valor na atual conta, e sacar**
```java
valor = Double.parseDouble(JOptionPane.showInputDialog(
        "Digite o valor que deseja depositar: "));
conta.depositar(valor);

valor = Double.parseDouble(JOptionPane.showInputDialog(
        "Digite o valor que deseja sacar: "));
conta.sacar(valor);
```

---

> **No final, a conta é criada e adicionada a uma ArrayList, e as informações das contas criadas são exibidas no terminal**
```java
List<Conta> contas = new ArrayList<>();
contas.add(conta);

try {
    for (Conta c : contas) c.extrato();
    } catch (NullPointerException e) {
        System.out.println("Nenhuma conta criada!");
    }
```
