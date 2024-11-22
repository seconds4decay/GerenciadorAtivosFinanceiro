package br.com.cesarschool.poo.titulos.repositorios;

import br.com.cesarschool.poo.titulos.entidades.Acao;
import br.com.cesarschool.poo.titulos.entidades.EntidadeOperadora;
import br.gov.cesarschool.poo.daogenerico.DAOSerializadorObjetos;
import br.gov.cesarschool.poo.daogenerico.Entidade;

public class RepositorioEntidadeOperadora extends RepositorioGeral {


    public RepositorioEntidadeOperadora() {
        super(EntidadeOperadora.class);
    }

    public boolean incluir(EntidadeOperadora entidadeOperadora) {
        if (buscar(entidadeOperadora.getIdentificador()) != null) {
            return false;
        }
        return dao.incluir(entidadeOperadora);
    }

    public boolean alterar(EntidadeOperadora entidadeOperadora) {
        return dao.alterar(entidadeOperadora);
    }

    public boolean excluir(long identificador) {
        EntidadeOperadora entidadeOperadora = buscar(identificador);
        if (entidadeOperadora != null) {
            return dao.excluir(String.valueOf(identificador));
        }
        return false;
    }

    public EntidadeOperadora buscar(long identificador) {
        return (EntidadeOperadora) dao.buscar(String.valueOf(identificador));
    }

    public Class<?> getClasseEntidade() {
        return classeEntidade;
    }

    public DAOSerializadorObjetos getDao() {
        return dao;
    }
}
