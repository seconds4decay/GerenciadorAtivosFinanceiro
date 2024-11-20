package br.com.cesarschool.poo.titulos.repositorios;

import br.com.cesarschool.poo.titulos.entidades.Acao;
import br.gov.cesarschool.poo.testes.daogenerico.DAOSerializadorObjetos;
import br.gov.cesarschool.poo.testes.daogenerico.Entidade;

import java.util.List;
import java.util.Objects;

public class RepositorioAcao extends RepositorioGeral {

	private DAOSerializadorObjetos daoAcao;

	public RepositorioAcao() {
		this.daoAcao = new DAOSerializadorObjetos(Acao.class);
	}

	public boolean incluir(Acao acao) {
		if (buscar(acao.getIdentificador()) != null) {
			return false;
		}
		return daoAcao.incluir(acao);
	}

	public boolean alterar(Acao acao) {
		return daoAcao.alterar(acao);
	}

	public boolean excluir(int identificador) {
		Acao acao = buscar(identificador);
		if (acao != null) {
			return daoAcao.excluir(String.valueOf(identificador));
		}
		return false;
	}

	public Acao buscar(int identificador) {
		return (Acao) daoAcao.buscar(String.valueOf(identificador));
	}

	public DAOSerializadorObjetos getDao() {
		return daoAcao;
	}
}
