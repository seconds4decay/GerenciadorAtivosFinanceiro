package br.com.cesarschool.poo.titulos.repositorios;

import br.com.cesarschool.poo.titulos.entidades.Acao;
import br.gov.cesarschool.poo.daogenerico.DAOSerializadorObjetos;

public class RepositorioAcao extends RepositorioGeral<Acao> {

	public RepositorioAcao() {
		super(Acao.class);
	}

	public boolean incluir(Acao acao) {
		if (buscar(acao.getIdentificador()) != null) {
			return false;
		}
		return dao.incluir(acao);
	}

	public boolean alterar(Acao acao) {
		return dao.alterar(acao);
	}

	public boolean excluir(int identificador) {
		Acao acao = buscar(identificador);
		if (acao != null) {
			return dao.excluir(String.valueOf(identificador));
		}
		return false;
	}

	public Acao buscar(int identificador) {
		return (Acao) dao.buscar(String.valueOf(identificador));
	}

	@Override
	public Class<Acao> getClasseEntidade() {
		return classeEntidade;
	}

	public DAOSerializadorObjetos getDao() {
		return dao;
	}
}
