package br.com.cesarschool.poo.titulos.relatorios;

import br.com.cesarschool.poo.titulos.entidades.Transacao;
import br.com.cesarschool.poo.titulos.repositorios.RepositorioTransacao;
import br.com.cesarschool.poo.titulos.utils.Comparador;
import br.com.cesarschool.poo.titulos.utils.ComparadorTransacaoPorNomeCredora;
import br.com.cesarschool.poo.titulos.utils.ComparadorTransacaoPorDataHora;
import br.com.cesarschool.poo.titulos.utils.Ordenador;

public class RelatorioTransacaoBroker {
    private final RepositorioTransacao repositorio;

    public RelatorioTransacaoBroker() {
        this.repositorio = new RepositorioTransacao();
    }

    public Transacao[] relatorioTransacaoPorNomeEntidadeCredora() {
        Transacao[] transacoes = repositorio.buscarTodos();

        Comparador ComparadorTransacaoPorNomeCredora = new ComparadorTransacaoPorNomeCredora();
        Ordenador.ordenar(transacoes, ComparadorTransacaoPorNomeCredora);
        return transacoes;
    }

    public Transacao[] relatorioTransacaoPorDataHora() {
        Transacao[] transacoes = repositorio.buscarTodos();

        Comparador ComparadorTransacaoPorDataHora = new ComparadorTransacaoPorDataHora();
        Ordenador.ordenar(transacoes, ComparadorTransacaoPorDataHora);
        return transacoes;
    }
}
