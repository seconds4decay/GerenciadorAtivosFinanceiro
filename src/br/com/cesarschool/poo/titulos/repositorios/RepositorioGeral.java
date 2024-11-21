package br.com.cesarschool.poo.titulos.repositorios;

import br.gov.cesarschool.poo.daogenerico.DAOSerializadorObjetos;
import br.gov.cesarschool.poo.daogenerico.Entidade;

public abstract class RepositorioGeral<T extends Entidade> {
    Class<T> classeEntidade;
    DAOSerializadorObjetos dao;

    RepositorioGeral(Class<T> classeEntidade) {
        this.classeEntidade = classeEntidade;
        this.dao = new DAOSerializadorObjetos<>(classeEntidade);
    }

    public abstract Class<T> getClasseEntidade();

    public abstract DAOSerializadorObjetos<T> getDao();
}
