package br.com.cesarschool.poo.titulos.repositorios;

import br.com.cesarschool.poo.titulos.entidades.EntidadeOperadora;
import br.com.cesarschool.poo.titulos.entidades.TituloDivida;
import br.gov.cesarschool.poo.daogenerico.DAOSerializadorObjetos;
import br.gov.cesarschool.poo.daogenerico.Entidade;

import java.io.IOException;
import java.util.List;

public class RepositorioTituloDivida extends RepositorioGeral<TituloDivida> {

	public RepositorioTituloDivida() {
		super(TituloDivida.class);
	}

	public boolean incluir(TituloDivida tituloDivida) throws IOException {
		TituloDivida existente = buscar(tituloDivida.getIdentificador());
		if (existente != null) {
			return false;
		}
		return dao.incluir(tituloDivida);
	}

	public boolean alterar(TituloDivida tituloDivida) throws IOException {
		return dao.alterar(tituloDivida);
	}

	public boolean excluir(int identificador) throws IOException {
		TituloDivida tituloDivida = buscar(identificador);
		if (tituloDivida == null) {
			return false;
		}
		return dao.excluir(String.valueOf(tituloDivida.getIdUnico()));
	}

	public TituloDivida buscar(int identificador) throws IOException {
		return (TituloDivida) dao.buscar(String.valueOf(identificador));
	}

	public List<Entidade> buscarTodos() throws IOException {
		return List.of(dao.buscarTodos());
	}

	@Override
	public Class<TituloDivida> getClasseEntidade() {
		return classeEntidade;
	}

	public DAOSerializadorObjetos getDao() {
		return dao;
	}
}
