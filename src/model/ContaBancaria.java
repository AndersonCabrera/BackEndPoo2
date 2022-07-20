package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;

public abstract class ContaBancaria {
   // #region Atributos
   protected String agencia;

   protected String conta;

   protected Integer digito;

   protected Double saldo;

   protected Date dataAbertura;

   protected ArrayList<Movimentacao> movimentacoes;

   protected Double VALOR_MINIMO_DEPOSITO = 10.0;

   // #endregion

   // #region Construtores
   public ContaBancaria(String agencia, String conta, Integer digito, Double saldoInicial) {
      this.agencia = agencia;
      this.conta = conta;
      this.digito = digito;
      this.saldo = saldoInicial;
      this.dataAbertura = new Date();

      // Estanciar a ArrayList para nao dar uma exception de nullPointerException.
      this.movimentacoes = new ArrayList<Movimentacao>();

      // Criando a primeira movimentação
      Movimentacao movimentacao = new Movimentacao("Abertura de conta", saldoInicial);

      // Aqui estou salvando a movimentação dentro do meu Array de movimentacoes.
      // Aqui estou iniciando o meu extrato bancario.
      this.movimentacoes.add(movimentacao);

   }
   // #endregion

   // #region Getters e Setters

   public Date getDataAbertura() {
      return dataAbertura;
   }

   public String getAgencia() {
      return agencia;
   }

   public void setAgencia(String agencia) {
      this.agencia = agencia;
   }

   public String getConta() {
      return conta;
   }

   public void setConta(String conta) {
      this.conta = conta;
   }

   public Integer getDigito() {
      return digito;
   }

   public void setDigito(Integer digito) {
      this.digito = digito;
   }

   public Double getSaldo() {
      return saldo;
   }
   // #endregion

   // #region Métodos
   // Verifica se o valor de deposito é menor que o valor minimo
   // se nao for pode acontecer o deposito
   public void depositar(Double valor) {
      if (valor < VALOR_MINIMO_DEPOSITO) {
         throw new InputMismatchException("O valor minimo de deposito é R$" + VALOR_MINIMO_DEPOSITO);

      }
      // Efetua o depósito somando o valor ao saldo
      this.saldo += valor;

      // Aqui faço uma movimentação no extrato
      Movimentacao movimentacao = new Movimentacao("Depósito", valor);
      this.movimentacoes.add(movimentacao);

   }

   public Double sacar(Double valor) {
      // verifica se o valor é maior que o saldo da conta
      // se for, manda mensagem de saldo é insuficiente
      if (valor > this.saldo) {
         throw new InputMismatchException("O saldo é insuficiente");

      }
      this.saldo -= valor;

      // Aqui faço uma movimentação no extrato
      Movimentacao movimentacao = new Movimentacao("Retirada de valor:", valor);
      this.movimentacoes.add(movimentacao);

      return valor;

   }

   // efetua saque na conta atual
   public void transferir(Double valor, ContaBancaria contaDestino) {
      this.sacar(valor);

      // Efetua o depósito na conta de destino
      contaDestino.depositar(valor);

   }

   public abstract void imprimirExtrato();

   // #endregion

}
