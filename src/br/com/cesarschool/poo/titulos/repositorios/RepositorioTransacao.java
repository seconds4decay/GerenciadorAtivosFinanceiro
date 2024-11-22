package br.com.cesarschool.poo.titulos.repositorios;

import br.com.cesarschool.poo.titulos.entidades.Transacao;
import br.gov.cesarschool.poo.daogenerico.DAOSerializadorObjetos;
import br.gov.cesarschool.poo.daogenerico.Entidade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RepositorioTransacao extends RepositorioGeral<Transacao> {

	public RepositorioTransacao() {
		super(Transacao.class);
	}

	public boolean incluir(Transacao transacao) throws IOException {
		return dao.incluir(transacao);
	}

	public Transacao[] buscarPorEntidadeCredora(long identificadorEntidadeCredito) throws IOException {
		Entidade[] todasEntidades = dao.buscarTodos();

		List<Transacao> transacoesEncontradas = new ArrayList<>();
		for (Entidade entidade : todasEntidades) {
			Transacao transacao = (Transacao) entidade;
			if (transacao.getEntidadeCredito().getIdentificador() == identificadorEntidadeCredito) {
				transacoesEncontradas.add(transacao);
			}
		}

		return transacoesEncontradas.isEmpty() ? new Transacao[0] : transacoesEncontradas.toArray(new Transacao[0]);
	}

	@Override
	public Class<Transacao> getClasseEntidade() {
		return classeEntidade;
	}

	public DAOSerializadorObjetos getDao() {
		return dao;
	}

	public Transacao[] buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
}
