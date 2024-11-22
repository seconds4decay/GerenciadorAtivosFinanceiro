package br.gov.cesarschool.poo.testes;

import br.com.cesarschool.poo.titulos.utils.Comparavel;
import br.gov.cesarschool.poo.daogenerico.Entidade;

class EntidadeModelo extends Entidade implements Comparavel {
	private int id;
	private String nome;

	EntidadeModelo(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	int getId() {
		return id;
	}
	String getNome() {
		return nome;
	}

	public String getIdUnico() {
		return "" + id;
	}

	public String toString() {
		return nome;
	}

	public int compararCom(Comparavel c) {
		EntidadeModelo em = (EntidadeModelo)c;
		return nome.compareTo(em.nome);
	}
}