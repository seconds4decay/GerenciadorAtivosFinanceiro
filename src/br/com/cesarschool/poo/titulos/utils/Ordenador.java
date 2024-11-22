package br.com.cesarschool.poo.titulos.utils;


public class Ordenador {

    public static void ordenar(Comparavel[] ents) {
        for (int i = 0; i < ents.length; i++) {
            for (int j = 0; j < ents.length; j++) {
                if(i == j) {
                    continue;
                }
                if (ents[i].compararCom(ents[j]) < 0) {
                    Comparavel temp = ents[i];
                    ents[i] = ents[j];
                    ents[j] = temp;
                }
            }
        }
    }

    public static void ordenar(Comparavel[] ents, Comparador c) {
        for (int i = 0; i < ents.length; i++) {
            for (int j = 0; j < ents.length; j++) {
                if(i == j) {
                    continue;
                }
                if (c.comparar(ents[i], ents[j]) < 0) {
                    Comparavel temp = ents[i];
                    ents[i] = ents[j];
                    ents[j] = temp;
                }
            }
        }
    }
}

