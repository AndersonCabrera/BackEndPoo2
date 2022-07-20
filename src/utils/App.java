package utils;

import model.ContaCorrente;
import model.ContaPoupanca;
import model.Movimentacao;

public class App {

   public static void main(String[] args) {
      System.out.println("Criando nosso Banco Digital");
      System.out.println();
      // #region Conta Corrente
      ContaCorrente conta = new ContaCorrente("0001", "7542", 5, 100.0);

      System.out.println("Saldo atual  CC de R$" + conta.getSaldo());
      System.out.println();

      conta.depositar(250.0);
      System.out.println("Saldo atual CC de R$" + conta.getSaldo());
      System.out.println();

      Double saque = conta.sacar(150.0);
      System.out.println("Saldo atual CC de R$" + conta.getSaldo());
      System.out.println();
      // #endregion

      // #region Conta Poupança
      ContaPoupanca conta2 = new ContaPoupanca("0001", "7543", 6, 200.0);

      conta2.transferir(100.0, conta);
      System.out.println("Saldo conta Poupança de R$" + conta2.getSaldo());
      System.out.println();

      System.out.println("Saldo atual CC de R$" + conta.getSaldo());
      System.out.println();

      System.out.println(conta2.getDataAbertura());

      String formatado = DataUtil.converterDateParaDataEHora(conta2.getDataAbertura());
      System.out.println(formatado);
      // #endregion

      // Extrato bancario é composto por movimentações bancarias.
      // Ter algo que possa ser a movimentação.
      // Ter uma lista de movimentações.

      Movimentacao movimentacao = new Movimentacao("Saque", 100.0);

      System.out.println(movimentacao);

      movimentacao.toString();

      // Conta Corrente
      conta.imprimirExtrato();
      System.out.println();

      // Conta poupança
      conta2.imprimirExtrato();

   }
}
