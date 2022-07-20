package model;

import java.util.Date;

import utils.DataUtil;

public class ContaCorrente extends ContaBancaria {

   public ContaCorrente(String agencia, String conta, Integer digito, Double saldoInicial) {
      // Por baixo cria uma conta Bancaria (conta pai)
      super(agencia, conta, digito, saldoInicial);

   }

   @Override
   public void imprimirExtrato() {
      System.out.println("**************************************");
      System.out.println("*********** Extrato Bancário *********");
      System.out.println("**************************************");
      System.out.println();

      System.out.println("Gerado em : " + DataUtil.converterDateParaDataEHora(new Date()));
      System.out.println();

      for (Movimentacao movimentacao : this.movimentacoes) {
         System.out.println(movimentacao);
         System.out.println();

      }
      System.out.println();
      System.out.println("**************************************");
      System.out.println("**************************************");
      System.out.println("**************************************");

   }
}
