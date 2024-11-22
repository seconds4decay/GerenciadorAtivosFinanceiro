package br.com.cesarschool.poo.titulos.utils;

import br.com.cesarschool.poo.titulos.entidades.Transacao;

public class ComparadorTransacaoPorDataHora extends ComparadorPadrao {

    public int comparar(Comparavel c1, Comparavel c2) {
        Transacao t1 = (Transacao) c1;
        Transacao t2 = (Transacao) c2;

        return t2.getDataHoraOperacao().compareTo(t1.getDataHoraOperacao());
    }

}
