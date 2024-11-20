package br.com.cesarschool.poo.titulos.repositorios;

import br.com.cesarschool.poo.titulos.entidades.EntidadeOperadora;
import br.gov.cesarschool.poo.testes.daogenerico.DAOSerializadorObjetos;

public class RepositorioEntidadeOperadora extends RepositorioGeral {

    private DAOSerializadorObjetos<EntidadeOperadora> daoEntidadeOperadora;

    public RepositorioEntidadeOperadora() {
        this.daoEntidadeOperadora = new DAOSerializadorObjetos<>(EntidadeOperadora.class);
    }

    public boolean incluir(EntidadeOperadora entidadeOperadora) {
        if (buscar(entidadeOperadora.getIdentificador()) != null) {
            return false;
        }
        return daoEntidadeOperadora.incluir(entidadeOperadora);
    }

    public boolean alterar(EntidadeOperadora entidadeOperadora) {
        return daoEntidadeOperadora.alterar(entidadeOperadora);
    }

    public boolean excluir(long identificador) {
        EntidadeOperadora entidadeOperadora = buscar(identificador);
        if (entidadeOperadora != null) {
            return daoEntidadeOperadora.excluir(String.valueOf(identificador));
        }
        return false;
    }

    public EntidadeOperadora buscar(long identificador) {
        return (EntidadeOperadora) daoEntidadeOperadora.buscar(String.valueOf(identificador));
    }

    public DAOSerializadorObjetos<EntidadeOperadora> getDao() {
        return daoEntidadeOperadora;
    }
}
