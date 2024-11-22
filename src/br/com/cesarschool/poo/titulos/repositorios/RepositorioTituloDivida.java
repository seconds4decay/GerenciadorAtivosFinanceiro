package br.com.cesarschool.poo.titulos.repositorios;

import br.com.cesarschool.poo.titulos.entidades.EntidadeOperadora;
import br.com.cesarschool.poo.titulos.entidades.TituloDivida;
import br.gov.cesarschool.poo.daogenerico.DAOSerializadorObjetos;
import br.gov.cesarschool.poo.daogenerico.Entidade;

import java.io.IOException;
import java.util.List;

public class RepositorioTituloDivida extends RepositorioGeral {

	public RepositorioTituloDivida() {
		super(TituloDivida.class);
	}

	public boolean incluir(TituloDivida tituloDivida) {
		TituloDivida existente = (TituloDivida) dao.buscar(tituloDivida.getIdUnico());
		if (existente != null) {
			return false;
		}
		return dao.incluir(tituloDivida);
	}

	public boolean alterar(TituloDivida tituloDivida) {
		return dao.alterar(tituloDivida);
	}

	public boolean excluir(int identificador) {
		TituloDivida tituloDivida = buscar(identificador);
		if (tituloDivida == null) {
			return false;
		}
		return dao.excluir(String.valueOf(tituloDivida.getIdUnico()));
	}

	public TituloDivida buscar(int identificador) {
		return (TituloDivida) dao.buscar(String.valueOf(identificador));
	}

	public List<Entidade> buscarTodos() {
		return List.of(dao.buscarTodos());
	}

	@Override
	public Class<?> getClasseEntidade() {
		return classeEntidade;
	}

	public DAOSerializadorObjetos getDao() {
		return dao;
	}
}
