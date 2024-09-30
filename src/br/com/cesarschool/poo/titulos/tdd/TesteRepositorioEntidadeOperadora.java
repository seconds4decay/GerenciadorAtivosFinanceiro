package br.com.cesarschool.poo.titulos.tdd;

import br.com.cesarschool.poo.titulos.entidades.EntidadeOperadora;
import br.com.cesarschool.poo.titulos.repositorios.RepositorioEntidadeOperadora;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TesteRepositorioEntidadeOperadora {

    @BeforeAll
    public static void inserirElementos() throws IOException {
        RepositorioEntidadeOperadora r = new RepositorioEntidadeOperadora();

        EntidadeOperadora eO = new EntidadeOperadora(1, "dffdsf", true);
        EntidadeOperadora eO1 = new EntidadeOperadora(2, "fdsfsdf", false);
        boolean a = r.incluir(eO);
        boolean b = r.incluir(eO1);
        assertTrue(a);
    }

    @Test
    public void testeDeletar() throws IOException {
        RepositorioEntidadeOperadora r = new RepositorioEntidadeOperadora();
        boolean a = r.excluir(2);

        assertTrue(a);
    }

    @Test
    public void testeAlterar() throws IOException {
        RepositorioEntidadeOperadora r = new RepositorioEntidadeOperadora();
        EntidadeOperadora eO = new EntidadeOperadora(1, "dffdsf", false);
        boolean a = r.alterar(eO);

        assertTrue(a);
    }

    @AfterAll
    public static void apagarElementos() throws IOException {
        RepositorioEntidadeOperadora r = new RepositorioEntidadeOperadora();

        boolean a = r.excluir(1);
    }
}
