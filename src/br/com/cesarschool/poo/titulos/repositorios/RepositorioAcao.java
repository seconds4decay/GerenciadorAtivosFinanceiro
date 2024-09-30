package br.com.cesarschool.poo.titulos.repositorios;
import br.com.cesarschool.poo.titulos.entidades.Acao;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

/*
 * Deve gravar em e ler de um arquivo texto chamado Acao.txt os dados dos objetos do tipo
 * Acao. Seguem abaixo exemplos de linhas (identificador, nome, dataValidade, valorUnitario)
 * 
    1;PETROBRAS;2024-12-12;30.33
    2;BANCO DO BRASIL;2026-01-01;21.21
    3;CORREIOS;2027-11-11;6.12
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
public class RepositorioAcao {
	public boolean incluir(Acao acao) throws FileNotFoundException, IOException {
		if(buscar(acao.getIdentificador()) == null) {
			FileWriter writer = new FileWriter("Acao.txt", true);

			writer.write(acao.getIdentificador() + ";" + acao.getNome() + ";" + acao.getDataValidade() + ";" + acao.getValorUnitario() + System.lineSeparator());
			writer.close();
			System.out.println();
			return true;
		} else {
			return false;
		}
	}

	public boolean alterar(Acao acao) throws IOException {
        File fileAcao = new File("Acao.txt");

        if (!fileAcao.exists()) {
            fileAcao.createNewFile();
        }

        Scanner sc = new Scanner(fileAcao);
        StringBuffer buffer = new StringBuffer();

        int id = acao.getIdentificador();
        String nome = acao.getNome();
        LocalDate dataValidade = acao.getDataValidade();
        double valorUnitario = acao.getValorUnitario();

        String novaLinha = String.format("%d;%s;%s;" +valorUnitario, id, nome, dataValidade);
        String antigaLinha = "";

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
			String[] dados = linha.split(";");

            if (dados[0].equals(String.valueOf(acao.getIdentificador()))) {
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

		FileWriter writer = new FileWriter(fileAcao);
		writer.write(buffer.toString());
		writer.close();
		return true;
    }

	public boolean excluir(int identificador) throws IOException {
		File fileAcao = new File("Acao.txt");
		boolean confirm = false;

		if (!fileAcao.exists()) {
			fileAcao.createNewFile();
		}

		Scanner sc = new Scanner(fileAcao);
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

		FileWriter writer = new FileWriter(fileAcao);
		writer.write(buffer.toString());
		writer.close();
		return true;
	}

	public Acao buscar(int identificador) throws IOException {
		File fileAcao = new File("Acao.txt");

		if(!fileAcao.exists()) {
			fileAcao.createNewFile();
		}

		Scanner reader = new Scanner(fileAcao);

		while(reader.hasNextLine()) {
			String linha = reader.nextLine();
			String[] dados = linha.split(";");

			if(dados[0].equals(String.valueOf(identificador))) {
				int id = Integer.parseInt(dados[0]);
				String nome = dados[1];
				LocalDate dataValidade = LocalDate.parse(dados[2]);
				double valorUnitario = Double.parseDouble(dados[3]);
				return new Acao(id, nome, dataValidade, valorUnitario);
			}
		}

		return null;
	}
}
