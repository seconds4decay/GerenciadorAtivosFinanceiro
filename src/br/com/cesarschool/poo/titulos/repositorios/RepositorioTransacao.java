package br.com.cesarschool.poo.titulos.repositorios;

import br.com.cesarschool.poo.titulos.entidades.Transacao;
import br.gov.cesarschool.poo.testes.daogenerico.DAOSerializadorObjetos;
import br.gov.cesarschool.poo.testes.daogenerico.Entidade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RepositorioTransacao extends RepositorioGeral {

	private DAOSerializadorObjetos<Transacao> daoTransacao;
	private RepositorioAcao repositorioAcao;
	private RepositorioEntidadeOperadora repositorioEntidade;
	private RepositorioTituloDivida repositorioTituloDivida;

	public RepositorioTransacao() {
		this.daoTransacao = new DAOSerializadorObjetos<>(Transacao.class);
		this.repositorioAcao = new RepositorioAcao();
		this.repositorioEntidade = new RepositorioEntidadeOperadora();
		this.repositorioTituloDivida = new RepositorioTituloDivida();
	}

	public boolean incluir(Transacao transacao) throws IOException {
		return daoTransacao.incluir(transacao);
	}

	public Transacao[] buscarPorEntidadeCredora(long identificadorEntidadeCredito) throws IOException {
		Entidade[] todasEntidades = daoTransacao.buscarTodos();

		List<Transacao> transacoesEncontradas = new ArrayList<>();
		for (Entidade entidade : todasEntidades) {
			Transacao transacao = (Transacao) entidade;
			if (transacao.getEntidadeCredito().getIdentificador() == identificadorEntidadeCredito) {
				transacoesEncontradas.add(transacao);
			}
		}

		return transacoesEncontradas.isEmpty() ? new Transacao[0] : transacoesEncontradas.toArray(new Transacao[0]);
	}

	public DAOSerializadorObjetos getDao() {
		return daoTransacao;
	}
}
