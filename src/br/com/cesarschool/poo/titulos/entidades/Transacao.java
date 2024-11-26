package br.com.cesarschool.poo.titulos.entidades;

import br.gov.cesarschool.poo.daogenerico.Entidade;
import br.com.cesarschool.poo.titulos.utils.Comparavel;

import java.time.LocalDateTime;

/*
 * Esta classe deve ter os seguintes atributos:
 * entidadeCredito, do tipo EntidadeOperadora
 * entidadeDebito, do tipo EntidadeOperadora
 * acao, do tipo Acao
 * tituloDivida, do tipo TituloDivida
 * valorOperacao, do tipo double
 * dataHoraOperacao, do tipo LocalDateTime
 *  
 * Deve ter um construtor p�blico que inicializa os atributos.
 * Deve ter m�todos get/set p�blicos para todos os atributos, que 
 * s�o read-only fora da classe.
 * 
 *  
 */ 
public class Transacao extends Entidade implements Comparavel {
    private EntidadeOperadora entidadeCredito;
    private EntidadeOperadora entidadeDebito;
    private Acao acao;
    private TituloDivida tituloDivida;
    private double valorOperacao;
    private LocalDateTime dataHoraOperacao;

    public Transacao(EntidadeOperadora entidadeCredito, EntidadeOperadora entidadeDebito, Acao acao, TituloDivida tituloDivida, double valorOperacao, LocalDateTime dataHoraOperacao) {
        this.entidadeCredito = entidadeCredito;
        this.entidadeDebito = entidadeDebito;
        this.acao = acao;
        this.tituloDivida = tituloDivida;
        this.valorOperacao = valorOperacao;
        this.dataHoraOperacao = dataHoraOperacao;
    }

    public EntidadeOperadora getEntidadeCredito() {
        return entidadeCredito;
    }

    private void setEntidadeCredito(EntidadeOperadora entidadeCredito) {
        this.entidadeCredito = entidadeCredito;
    }

    public EntidadeOperadora getEntidadeDebito() {
        return entidadeDebito;
    }

    private void setEntidadeDebito(EntidadeOperadora entidadeDebito) {
        this.entidadeDebito = entidadeDebito;
    }

    public Acao getAcao() {
        return acao;
    }

    private void setAcao(Acao acao) {
        this.acao = acao;
    }

    public TituloDivida getTituloDivida() {
        return tituloDivida;
    }

    private void setTituloDivida(TituloDivida tituloDivida) {
        this.tituloDivida = tituloDivida;
    }

    public double getValorOperacao() {
        return valorOperacao;
    }

    private void setValorOperacao(double valorOperacao) {
        this.valorOperacao = valorOperacao;
    }

    public LocalDateTime getDataHoraOperacao() {
        return dataHoraOperacao;
    }

    private void setDataHoraOperacao(LocalDateTime dataHoraOperacao) {
        this.dataHoraOperacao = dataHoraOperacao;
    }

    public String getIdUnico() {
        String id = "";

        if(this.entidadeCredito != null) {
            id = id.concat(this.entidadeCredito.getIdUnico());
        }

        if(this.entidadeDebito != null) {
            id = id.concat("_" + this.entidadeDebito.getIdUnico());
        }

        if(this.acao != null) {
            id = id.concat("_" + this.acao.getIdUnico());
        } else if(this.tituloDivida != null) {
            id = id.concat("_" + this.tituloDivida.getIdUnico());
        }

        if(this.dataHoraOperacao != null) {
            id = id.concat("_"+ this.dataHoraOperacao.getYear() + this.dataHoraOperacao.getMonthValue() + this.dataHoraOperacao.getDayOfMonth() + this.dataHoraOperacao.getHour() + this.dataHoraOperacao.getMinute() + this.dataHoraOperacao.getSecond());
        }

        return id;
    }

    @Override
    public int compararCom(Comparavel c) {
        Transacao outraTransacao = (Transacao) c;

        if(this.dataHoraOperacao.isBefore(outraTransacao.dataHoraOperacao)) {
            return 1;
        } else if(this.dataHoraOperacao.isAfter(outraTransacao.dataHoraOperacao)) {
            return -1;
        } else {
            return 0;
        }
    }
}
