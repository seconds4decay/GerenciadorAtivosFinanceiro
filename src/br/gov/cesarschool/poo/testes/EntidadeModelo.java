package br.gov.cesarschool.poo.testes;

import br.com.cesarschool.poo.titulos.utils.Comparavel;
import br.gov.cesarschool.poo.daogenerico.Entidade;

public class EntidadeModelo extends Entidade implements Comparavel {
	private int id; 
	private String nome;
	public EntidadeModelo(int id2, String nome2) {
		// TODO Auto-generated constructor stub
	}
	int getId() {
		return id;
	}
	String getNome() {
		return nome;
	}
	public int comparar(Comparavel c1) {
		EntidadeModelo em = (EntidadeModelo)c1;			
		return nome.compareTo(em.nome);
	}
	public String getIdUnico() {
		return "" + id;
	}		
	public String toString() {
		return nome;
	}
	@Override
	public int compararCom(Object outro) {
	    if (outro instanceof EntidadeModelo) {
	        EntidadeModelo outroModelo = (EntidadeModelo) outro;
	        // Primeiro, compara os IDs
	        int comparacaoId = Integer.compare(this.id, outroModelo.getId());
	        if (comparacaoId != 0) {
	            return comparacaoId;
	        }
	        // Se os IDs forem iguais, compara pelo nome
	        return this.nome.compareTo(outroModelo.getNome());
	    }
	    // Se o objeto não for do tipo esperado, considere como não comparável
	    throw new IllegalArgumentException("Objeto não é uma instância de EntidadeModelo");
	}

}