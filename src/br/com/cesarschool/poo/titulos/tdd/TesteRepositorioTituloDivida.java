package br.com.cesarschool.poo.titulos.tdd;

import br.com.cesarschool.poo.titulos.entidades.TituloDivida;
import br.com.cesarschool.poo.titulos.repositorios.RepositorioTituloDivida;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TesteRepositorioTituloDivida {

    @BeforeAll
    static void inserirElementos() throws IOException {
        RepositorioTituloDivida r = new RepositorioTituloDivida();

        TituloDivida td = new TituloDivida(1, "BRASIL", LocalDate.parse("2024-12-12"), 10.5);
        boolean a = r.incluir(td);

        TituloDivida td1 = new TituloDivida(2, "EUA", LocalDate.parse("2026-01-01"), 1.5);
        boolean b = r.incluir(td1);

        assertTrue(a);
        assertTrue(b);
    }

    @Test
    void testeAlterar() throws IOException {
        RepositorioTituloDivida r = new RepositorioTituloDivida();

        TituloDivida td = new TituloDivida(1, "BRASIL", LocalDate.parse("2024-12-12"), 15.5);
        boolean a = r.alterar(td);
        assertTrue(a);
    }

    @Test
    void testeApagar() throws IOException {
        RepositorioTituloDivida r = new RepositorioTituloDivida();

        boolean a = r.excluir(2);
        assertTrue(a);
    }

    @AfterAll
    static void deletarElementos() throws IOException {
        RepositorioTituloDivida r = new RepositorioTituloDivida();

        boolean a = r.excluir(1);

        assertTrue(a);
    }

}
