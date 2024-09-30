package br.com.cesarschool.poo.titulos.repositorios;

import br.com.cesarschool.poo.titulos.entidades.Acao;
import br.com.cesarschool.poo.titulos.entidades.EntidadeOperadora;
import br.com.cesarschool.poo.titulos.entidades.TituloDivida;
import br.com.cesarschool.poo.titulos.entidades.Transacao;

import javax.sound.midi.SysexMessage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/*
 * Deve gravar em e ler de um arquivo texto chamado Transacao.txt os dados dos objetos do tipo
 * Transacao. Seguem abaixo exemplos de linhas 
 * De entidadeCredito: identificador, nome, autorizadoAcao, saldoAcao, saldoTituloDivida.
 * De entidadeDebito: identificador, nome, autorizadoAcao, saldoAcao, saldoTituloDivida.
 * De acao: identificador, nome, dataValidade, valorUnitario OU null
 * De tituloDivida: identificador, nome, dataValidade, taxaJuros OU null. 
 * valorOperacao, dataHoraOperacao
 *
 *   002192;BCB;true;0.00;1890220034.0;001112;BOFA;true;12900000210.00;3564234127.0;1;PETROBRAS;2024-12-12;30.33;null;100000.0;2024-01-01 12:22:21
 *   002192;BCB;false;0.00;1890220034.0;001112;BOFA;true;12900000210.00;3564234127.0;null;3;FRANCA;2027-11-11;2.5;100000.0;2024-01-01 12:22:21
 *
 *
 * A inclusão deve adicionar uma nova linha ao arquivo. 
 * 
 * A busca deve retornar um array de transações cuja entidadeCredito tenha identificador igual ao
 * recebido como parâmetro.  
 */
public class RepositorioTransacao {
	RepositorioAcao repositorioAcao = new RepositorioAcao();
	RepositorioEntidadeOperadora repositorioEntidade = new RepositorioEntidadeOperadora();
	RepositorioTituloDivida repositorioTituloDivida = new RepositorioTituloDivida();

	public void incluir(Transacao transacao) throws FileNotFoundException, IOException {
		FileWriter writer = new FileWriter("Transacao.txt", true);
		StringBuffer linha = new StringBuffer();

		EntidadeOperadora entidadeCredito = transacao.getEntidadeCredito();
		EntidadeOperadora entidadeDebito = transacao.getEntidadeDebito();
		Acao acao = transacao.getAcao();
		TituloDivida tituloDivida = transacao.getTituloDivida();

		linha.append(entidadeCredito.getIdentificador()).append(";").append(entidadeCredito.getNome()).append(";").append(entidadeCredito.getAutorizadoAcao()).append(";").append(entidadeCredito.getSaldoAcao()).append(";").append(entidadeCredito.getSaldoTituloDivida()).append(";");
		linha.append(entidadeDebito.getIdentificador()).append(";").append(entidadeDebito.getNome()).append(";").append(entidadeDebito.getAutorizadoAcao()).append(";").append(entidadeDebito.getSaldoAcao()).append(";").append(entidadeDebito.getSaldoTituloDivida()).append(";");

		if(acao == null) {
			linha.append("null").append(";");
		} else {
			linha.append(acao.getIdentificador()).append(";").append(acao.getNome()).append(";").append(acao.getDataValidade()).append(";").append(acao.getValorUnitario()).append(";");
		}

		if(tituloDivida == null) {
			linha.append("null").append(";");
		} else {
			linha.append(tituloDivida.getIdentificador()).append(";").append(tituloDivida.getNome()).append(";").append(tituloDivida.getDataValidade()).append(";").append(tituloDivida.getTaxaJuros()).append(";");
		}

		linha.append(transacao.getValorOperacao()).append(";").append(transacao.getDataHoraOperacao());

		writer.write(linha.toString() + System.lineSeparator());

		writer.close();
	}

	public Transacao[] buscarPorEntidadeCredora(long identificadorEntidadeCredito) throws IOException {
		File fileAcao = new File("Transacao.txt");
		boolean confirm = false;

		if(!fileAcao.exists()) {
			fileAcao.createNewFile();
		}

		Scanner reader = new Scanner(fileAcao);
		List<Transacao> transacoes = new ArrayList<>();

		while(reader.hasNextLine()) {
			String linha = reader.nextLine();
			String[] dados = linha.split(";");

			if(dados[0].equals(String.valueOf(identificadorEntidadeCredito))) {
				confirm = true;

				EntidadeOperadora entidadeCredito = repositorioEntidade.buscar(Integer.parseInt(dados[0]));
				EntidadeOperadora entidadeDebito = repositorioEntidade.buscar(Integer.parseInt(dados[5]));
				Acao acao = null;
				TituloDivida tituloDivida = null;
				double valorOperacao = 0.0;
				LocalDateTime dataHoraOperacao = null;

				if(dados[10].equals("null")) {


					if(dados[11].equals("null")) {
						valorOperacao = Double.parseDouble(dados[12]);
						dataHoraOperacao = LocalDateTime.parse(dados[13]);
					} else {
						tituloDivida = repositorioTituloDivida.buscar(Integer.parseInt(dados[11]));
						valorOperacao = Double.parseDouble(dados[15]);
						dataHoraOperacao = LocalDateTime.parse(dados[16]);
					}

				} else {
					acao = repositorioAcao.buscar(Integer.parseInt(dados[10]));

					if(dados[14].equals("null")) {
						tituloDivida = null;
						valorOperacao = Double.parseDouble(dados[15]);
						dataHoraOperacao = LocalDateTime.parse(dados[16]);
					} else {
						tituloDivida = repositorioTituloDivida.buscar(Integer.parseInt(dados[14]));
						valorOperacao = Double.parseDouble(dados[18]);
						dataHoraOperacao = LocalDateTime.parse(dados[19]);
					}
				}

				transacoes.add(new Transacao(entidadeCredito, entidadeDebito, acao, tituloDivida, valorOperacao, dataHoraOperacao));
			}
		}

		reader.close();

		if(!confirm) {
			return null;
		}

		return transacoes.toArray(new Transacao[0]);
	}
}
