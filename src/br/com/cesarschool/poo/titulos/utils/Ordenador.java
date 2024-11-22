package br.com.cesarschool.poo.titulos.utils;

import java.util.Arrays;

import br.com.cesarschool.poo.titulos.entidades.Transacao;
import br.gov.cesarschool.poo.testes.EntidadeModelo;

public class Ordenador {

    // Ordena EntidadeModelo usando o método compararCom
    public static void ordenar(EntidadeModelo[] ents) {
        Arrays.sort(ents, (c1, c2) -> c1.comparar(c2));
    }

    // Ordena EntidadeModelo usando um Comparador fornecido
    public static void ordenar(EntidadeModelo[] ents, Comparador comparador) {
        Arrays.sort(ents, (c1, c2) -> comparador.comparar(c1, c2));
    }

    // Ordena Transacao por nome da entidade credora usando ComparadorTransacaoPorNomeCredora
    public static void ordenar(Transacao[] transacoes, Comparador comparador) {
        Arrays.sort(transacoes, (t1, t2) -> comparador.comparar(t1, t2));
    }

    // Ordena Transacao pelo método comparar implementado
    public static void ordenar(Transacao[] transacoes) {
        Arrays.sort(transacoes, (t1, t2) -> t1.comparar(t2));
    }
}

