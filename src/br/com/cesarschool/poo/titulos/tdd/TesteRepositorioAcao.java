package br.com.cesarschool.poo.titulos.tdd;

import br.com.cesarschool.poo.titulos.entidades.Acao;
import br.com.cesarschool.poo.titulos.repositorios.RepositorioAcao;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TesteRepositorioAcao {

    @Test
    public void testeInserir1() throws IOException {
        RepositorioAcao repositorio = new RepositorioAcao();

        LocalDate data = LocalDate.parse("2024-12-12");
        LocalDate data2 = LocalDate.parse("2026-01-01");
        LocalDate date3 = LocalDate.parse("2027-11-11");

        Acao acao = new Acao(1, "PETROBRAS", data, 30.33);
        Acao acao2 = new Acao(2, "BANCO DO BRASIL", data, 21.21);
        Acao acao3 = new Acao(3, "CORREIOS", date3, 6.12);

        boolean a = repositorio.incluir(acao);
        boolean b = repositorio.incluir(acao2);
        boolean c = repositorio.incluir(acao3);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        acao = new Acao(1, "PETROBRAS", data, 31.33);
        boolean d = repositorio.alterar(acao);

        acao2 = new Acao(4, "BANCO DO BRASIL", data, 22.21);
        boolean e = repositorio.alterar(acao2);

        System.out.println(d);
        System.out.println(e);


        boolean f = repositorio.excluir(1);
        System.out.println(f);

        assertTrue(f);
    }
}