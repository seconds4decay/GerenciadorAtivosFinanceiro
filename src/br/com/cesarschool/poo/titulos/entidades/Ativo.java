package br.com.cesarschool.poo.titulos.entidades;

import br.gov.cesarschool.poo.testes.daogenerico.Entidade;

import java.time.LocalDate;

/*
 * Esta classe deve ter os seguintes atributos:
 * identificador, do tipo int
 * nome, do tipo String
 * data de validade, do tipo LocalDate
 * 
 * Deve ter um construtor p�blico que inicializa os atributos, 
 * e m�todos set/get p�blicos para os atributos. O atributo identificador
 * � read-only fora da classe.
 */
public class Ativo extends Entidade {
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

    @Override
    public String getIdUnico() {
        return String.valueOf(identificador);
    }
}
