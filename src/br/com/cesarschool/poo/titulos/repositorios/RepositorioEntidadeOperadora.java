package br.com.cesarschool.poo.titulos.repositorios;

import br.com.cesarschool.poo.titulos.entidades.EntidadeOperadora;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * Deve gravar em e ler de um arquivo texto chamado Acao.txt os dados dos objetos do tipo
 * Acao. Seguem abaixo exemplos de linhas.
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
public class RepositorioEntidadeOperadora {
    public boolean incluir(EntidadeOperadora entidadeOperadora) throws FileNotFoundException, IOException {
        if(buscar(entidadeOperadora.getIdentificador()) == null) {
            FileWriter writer = new FileWriter("EntidadeOperadora.txt", true);

            writer.write(entidadeOperadora.getIdentificador() + ";" + entidadeOperadora.getNome() + ";" + entidadeOperadora.getAutorizadoAcao() + ";" + entidadeOperadora.getSaldoAcao() + ";" + entidadeOperadora.getSaldoTituloDivida() + System.lineSeparator());
            writer.close();
            System.out.println();
            return true;
        } else {
            return false;
        }
    }

    public boolean alterar(EntidadeOperadora entidadeOperadora) throws IOException {
        File fileEntidadeOperadora = new File("EntidadeOperadora.txt");

        if (!fileEntidadeOperadora.exists()) {
            fileEntidadeOperadora.createNewFile();
        }

        Scanner sc = new Scanner(fileEntidadeOperadora);
        StringBuffer buffer = new StringBuffer();

        long id = entidadeOperadora.getIdentificador();
        String nome = entidadeOperadora.getNome();
        boolean autorizadoAcao = entidadeOperadora.getAutorizadoAcao();
        double saldoAcao = entidadeOperadora.getSaldoAcao();
        double saldoTituloDivida = entidadeOperadora.getSaldoTituloDivida();

        String novaLinha = String.format("%d;%s;" + autorizadoAcao + ";" + saldoAcao + ";" + saldoTituloDivida, id, nome);
        String antigaLinha = "";

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] dados = linha.split(";");

            if (dados[0].equals(String.valueOf(entidadeOperadora.getIdentificador()))) {
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

        FileWriter writer = new FileWriter(fileEntidadeOperadora);
        writer.write(buffer.toString());
        writer.close();
        return true;
    }

    public boolean excluir(long identificador) throws IOException {
        File fileEntidadeOperadora = new File("EntidadeOperadora.txt");
        boolean confirm = false;

        if (!fileEntidadeOperadora.exists()) {
            return false;
        }

        Scanner sc = new Scanner(fileEntidadeOperadora);
        StringBuffer buffer = new StringBuffer();

        while (sc.hasNextLine()) {

            String linha = sc.nextLine();
            String[] dados = linha.split(";");

            if (!dados[0].equals(String.valueOf(identificador))) {
                buffer.append(linha).append(System.lineSeparator());
                confirm = true;
            }
        }

        sc.close();

        if(!confirm) {
            return false;
        }

        FileWriter writer = new FileWriter(fileEntidadeOperadora);
        writer.write(buffer.toString());
        writer.close();
        return true;
    }

    public EntidadeOperadora buscar(long identificador) throws IOException {
        File fileEntidadeOperadora = new File("EntidadeOperadora.txt");

        if(!fileEntidadeOperadora.exists()) {
            fileEntidadeOperadora.createNewFile();
        }

        Scanner reader = new Scanner(fileEntidadeOperadora);

        while(reader.hasNextLine()) {
            String linha = reader.nextLine();
            String[] dados = linha.split(";");

            if(dados[0].equals(String.valueOf(identificador))) {
                long id = Long.parseLong(dados[0]);
                String nome = dados[1];
                boolean autorizadoAcao = Boolean.parseBoolean(dados[2]);

                EntidadeOperadora novo = new EntidadeOperadora(id, nome, autorizadoAcao);

                novo.creditarSaldoAcao(Double.parseDouble(dados[3]));
                novo.creditarSaldoTituloDivida(Double.parseDouble(dados[4]));
                return novo;
            }
        }

        return null;
    }
}
