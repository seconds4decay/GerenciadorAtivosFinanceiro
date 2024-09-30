package br.com.cesarschool.poo.titulos.tdd;

import br.com.cesarschool.poo.titulos.entidades.Acao;
import br.com.cesarschool.poo.titulos.entidades.EntidadeOperadora;
import br.com.cesarschool.poo.titulos.entidades.TituloDivida;
import br.com.cesarschool.poo.titulos.entidades.Transacao;
import br.com.cesarschool.poo.titulos.repositorios.RepositorioTransacao;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TesteRepositorioTransacao {

    @Test
    void inserirTransacoes() throws IOException {
        RepositorioTransacao r = new RepositorioTransacao();

        // Criando as entidades credora e devedora
        EntidadeOperadora entidadeCredito = new EntidadeOperadora(1, "BCB", true);
        entidadeCredito.creditarSaldoAcao(0.00);
        entidadeCredito.creditarSaldoTituloDivida(1890220034.0);
        EntidadeOperadora entidadeDebito = new EntidadeOperadora(2, "BOFA", true);
        entidadeDebito.creditarSaldoAcao(12900000210.00);
        entidadeDebito.creditarSaldoTituloDivida(3564234127.0);

        // Criando a ação e o título da dívida
        Acao acao = new Acao(1, "PETROBRAS", LocalDate.parse("2024-12-12"), 30.33);
        TituloDivida tituloDivida = null; // Vamos deixar como null neste caso

        // Criando a primeira transação
        Transacao transacao1 = new Transacao(entidadeCredito, entidadeDebito, acao, tituloDivida, 100000.0, LocalDateTime.parse("2024-01-01T12:22:21"));
        r.incluir(transacao1);

        // Criando uma segunda transação, sem ação e com título de dívida
        TituloDivida tituloDivida2 = new TituloDivida(2, "FRANCA", LocalDate.parse("2027-11-11"), 2.5);
        Transacao transacao2 = new Transacao(entidadeCredito, entidadeDebito, null, tituloDivida2, 50000.0, LocalDateTime.parse("2024-01-01T15:00:00"));
        r.incluir(transacao2);
    }

}