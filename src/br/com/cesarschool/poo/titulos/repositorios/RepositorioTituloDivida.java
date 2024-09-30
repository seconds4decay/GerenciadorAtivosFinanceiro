package br.com.cesarschool.poo.titulos.repositorios;

import br.com.cesarschool.poo.titulos.entidades.Acao;
import br.com.cesarschool.poo.titulos.entidades.TituloDivida;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

/*
 * Deve gravar em e ler de um arquivo texto chamado TituloDivida.txt os dados dos objetos do tipo
 * TituloDivida. Seguem abaixo exemplos de linhas (identificador, nome, dataValidade, taxaJuros).
 *
    1;BRASIL;2024-12-12;10.5
    2;EUA;2026-01-01;1.5
    3;FRANCA;2027-11-11;2.5 
 * 
 * A inclusão deve adicionar uma nova linha ao arquivo. Não é permitido incluir 
 * identificador repetido. Neste caso, o metodo deve retornar false. Inclusão com
 * sucesso, retorno true.
 * 
 * A alteração deve substituir a linha atual por uma nova linha. A linha deve ser 
 * localizada por identificador que, quando não encontrado, enseja retorno false. 
 * Alteração com sucesso, retorno true.  
 *   
 * A exclusão deve apagar a linha atual do arquivo. A linha deve ser 
 * localizada por identificador que, quando não encontrado, enseja retorno false. 
 * Exclusão com sucesso, retorno true.
 * 
 * A busca deve localizar uma linha por identificador, materializar e retornar um 
 * objeto. Caso o identificador não seja encontrado no arquivo, retornar null.   
 */
public class RepositorioTituloDivida {
	public boolean incluir(TituloDivida tituloDivida) throws FileNotFoundException, IOException {
		if(buscar(tituloDivida.getIdentificador()) == null) {
			FileWriter writer = new FileWriter("Acao.txt", true);

			writer.write(tituloDivida.getIdentificador() + ";" + tituloDivida.getNome() + ";" + tituloDivida.getDataValidade() + ";" + tituloDivida.getTaxaJuros() + System.lineSeparator());
			writer.close();
			System.out.println();
			return true;
		} else {
			return false;
		}
	}

	public boolean alterar(TituloDivida tituloDivida) throws IOException {
		File fileTituloDivida = new File("Acao.txt");

		if (!fileTituloDivida.exists()) {
			fileTituloDivida.createNewFile();
		}

		Scanner sc = new Scanner(fileTituloDivida);
		StringBuffer buffer = new StringBuffer();

		int id = tituloDivida.getIdentificador();
		String nome = tituloDivida.getNome();
		LocalDate dataValidade = tituloDivida.getDataValidade();
		double taxaJuros = tituloDivida.getTaxaJuros();

		String novaLinha = String.format("%d;%s;%s;" + taxaJuros, id, nome, dataValidade);
		String antigaLinha = "";

		while (sc.hasNextLine()) {
			String linha = sc.nextLine();
			String[] dados = linha.split(";");

			if (dados[0].equals(String.valueOf(tituloDivida.getIdentificador()))) {
				antigaLinha = linha;
				buffer.append(novaLinha).append(System.lineSeparator());
			} else {
				buffer.append(linha).append(System.lineSeparator());
			}
		}

		sc.close();

		String linhas = buffer.toString();

		if (antigaLinha == "") {
			return false;
		}

		linhas.replaceAll(antigaLinha, novaLinha);

		FileWriter writer = new FileWriter(fileTituloDivida);
		writer.write(buffer.toString());
		writer.close();
		return true;
	}

	public boolean excluir(int identificador) throws IOException {
		File fileTituloDivida = new File("Acao.txt");
		boolean confirm = false;

		if (!fileTituloDivida.exists()) {
			fileTituloDivida.createNewFile();
		}

		Scanner sc = new Scanner(fileTituloDivida);
		StringBuffer buffer = new StringBuffer();

		while (sc.hasNextLine()) {
			String linha = sc.nextLine();
			String[] dados = linha.split(";");

			if (!dados[0].equals(String.valueOf(identificador))) {
				StringBuffer append = buffer.append(linha).append(System.lineSeparator());
				confirm = true;
			}
		}

		sc.close();

		if(!confirm) {
			return false;
		}

		String linhas = buffer.toString();

		FileWriter writer = new FileWriter(fileTituloDivida);
		writer.write(buffer.toString());
		writer.close();
		return true;
	}

	public TituloDivida buscar(int identificador) throws IOException {
		File fileTituloDivida = new File("TituloDivida.txt");

		if(!fileTituloDivida.exists()) {
			fileTituloDivida.createNewFile();
		}

		Scanner reader = new Scanner(fileTituloDivida);

		while(reader.hasNextLine()) {
			String linha = reader.nextLine();
			String[] dados = linha.split(";");

			if(dados[0].equals(String.valueOf(identificador))) {
				int id = Integer.parseInt(dados[0]);
				String nome = dados[1];
				LocalDate dataValidade = LocalDate.parse(dados[2]);
				double taxaJuros = Double.parseDouble(dados[3]);
				return new TituloDivida(id, nome, dataValidade, taxaJuros);
			}
		}

		return null;
	}
}
