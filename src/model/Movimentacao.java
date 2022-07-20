package model;

import java.util.Date;

import utils.DataUtil;

public class Movimentacao {

   // #region Atributos
   private String descricao;

   private Date data;

   private Double valor;
   // #endregion

   // #region Construtores
   public Movimentacao(String descricao, Double valor) {
      this.descricao = descricao;
      this.data = new Date();
      this.valor = valor;
   }
   // #endregion

   // #region Getters e Setters
   public String getDescricao() {
      return descricao;
   }

   public void setDescricao(String descricao) {
      this.descricao = descricao;
   }

   public Date getData() {
      return data;
   }

   public Double getValor() {
      return valor;
   }

   // Anotação
   @Override
   public String toString() {

      String dataFormatada = DataUtil.converterDateParaDataEHora(this.getData());

      return this.getDescricao() + "\n" + dataFormatada + " _ R$" + this.valor;

      // Descrição
      // Data e hora - valor
   }

   // #endregion

}
