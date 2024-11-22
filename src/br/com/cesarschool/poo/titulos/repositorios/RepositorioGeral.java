package br.com.cesarschool.poo.titulos.repositorios;

import br.gov.cesarschool.poo.daogenerico.DAOSerializadorObjetos;
import br.gov.cesarschool.poo.daogenerico.Entidade;

public abstract class RepositorioGeral {
    Class<?> classeEntidade;
    DAOSerializadorObjetos dao;

    RepositorioGeral(Class<?> classeEntidade) {
        this.classeEntidade = classeEntidade;
        this.dao = new DAOSerializadorObjetos(classeEntidade);
    }

    public abstract Class<?> getClasseEntidade();

    public abstract DAOSerializadorObjetos getDao();
}
