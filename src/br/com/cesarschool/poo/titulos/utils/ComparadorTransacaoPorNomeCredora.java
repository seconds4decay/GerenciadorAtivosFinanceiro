package br.com.cesarschool.poo.titulos.utils;

import br.com.cesarschool.poo.titulos.entidades.Transacao;

public class ComparadorTransacaoPorNomeCredora extends ComparadorPadrao {
    @Override
    public int comparar(Comparavel c1, Comparavel c2) {
        Transacao t1 = (Transacao) c1;
        Transacao t2 = (Transacao) c2;
        return t1.getEntidadeCredito().getNome().compareTo(t2.getEntidadeCredito().getNome());
    }

	@Override
	public int comparar(Object obj1, Object obj2) {
		// TODO Auto-generated method stub
		return 0;
	}
}
