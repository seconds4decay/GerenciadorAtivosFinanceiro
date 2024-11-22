package br.com.cesarschool.poo.titulos.relatorios;

import br.com.cesarschool.poo.titulos.entidades.Transacao;
import br.com.cesarschool.poo.titulos.repositorios.RepositorioTransacao;
import br.com.cesarschool.poo.titulos.utils.ComparadorTransacaoPorNomeCredora;
import br.com.cesarschool.poo.titulos.utils.Ordenador;
import br.gov.cesarschool.poo.testes.EntidadeModelo;

public class RelatorioTransacaoBroker {
    private final RepositorioTransacao repositorio;

    public RelatorioTransacaoBroker() {
        this.repositorio = new RepositorioTransacao();
    }

    public Transacao[] relatorioTransacaoPorNomeEntidadeCredora() {
        Transacao[] transacoes = repositorio.buscarTodos();
        Ordenador.ordenar(transacoes, new ComparadorTransacaoPorNomeCredora());
        return transacoes;
    }

    public Transacao[] relatorioTransacaoPorDataHora() {
        Transacao[] transacoes = repositorio.buscarTodos();
        Ordenador.ordenar(transacoes); // Usa a ordenação padrão da classe Transacao (por data/hora).
        return transacoes;
    }
}
