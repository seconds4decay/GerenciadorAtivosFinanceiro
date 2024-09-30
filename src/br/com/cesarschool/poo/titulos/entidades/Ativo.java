package br.com.cesarschool.poo.titulos.entidades;

import java.time.LocalDate;

/*
 * Esta classe deve ter os seguintes atributos:
 * identificador, do tipo int
 * nome, do tipo String
 * data de validade, do tipo LocalDate
 * 
 * Deve ter um construtor público que inicializa os atributos, 
 * e métodos set/get públicos para os atributos. O atributo identificador
 * é read-only fora da classe.
 */
public class Ativo {
    private int identificador;
    private String nome;
    private LocalDate dataValidade;

    public Ativo(int id, String nome, LocalDate dataValidade) {
        this.identificador = id;
        this.nome = nome;
        this.dataValidade = dataValidade;
    }

    public int getIdentificador() {
        return identificador;
    }

    private void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }
}
