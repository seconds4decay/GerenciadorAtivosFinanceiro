package br.com.cesarschool.poo.titulos.utils;

public class ComparadorPadrao implements Comparador {
    public int comparar(Comparavel c1, Comparavel c2) {
        return c1.compararCom(c2);
    }
}
