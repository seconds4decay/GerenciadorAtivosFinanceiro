package br.com.cesarschool.poo.titulos.entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;

/*
 * Esta classe deve herdar de Ativo.
 * E deve ter os seguintes atributos:
 * valorUnitario, do tipo double.
 * 
 * Deve ter um construtor peblico que inicializa os atributos,
 * e metodos set/get peblicos para os atributos.
 * 
 * Deve ter um metodo publico double calcularPrecoTransacao(double montante): o preço
 * da transação é o produto do montante pelo valorUnitario.
 */
public class Acao extends Ativo {
    double valorUnitario;

    public Acao(int id, String nome, LocalDate dataValidade, double valorUnitario) {
        super(id, nome, dataValidade);
        this.valorUnitario = valorUnitario;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double calcularPrecoTransacao(double montante) {
        return montante * valorUnitario;
    }
}
