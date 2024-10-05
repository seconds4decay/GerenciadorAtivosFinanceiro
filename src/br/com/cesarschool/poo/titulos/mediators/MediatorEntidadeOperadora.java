package br.com.cesarschool.poo.titulos.mediators;
import java.io.FileNotFoundException;
import java.io.IOException;

import br.com.cesarschool.poo.titulos.entidades.EntidadeOperadora;
import br.com.cesarschool.poo.titulos.repositorios.RepositorioEntidadeOperadora;

/*
 * Deve ser um singleton.
 * 
 * Deve ter um atributo repositorioEntidadeOperadora, do tipo RepositorioEntidadeOperadora, que deve 
 * ser inicializado na sua declaração. Este atributo será usado exclusivamente
 * pela classe, não tendo, portanto, métodos set e get.
 * 
 * Métodos: 
 * 
 * pivate String validar(EntidadeOperadora): deve validar os dados do objeto recebido nos seguintes termos: 
 * identificador: deve ser maior que zero e menor que 100000 (1)
 * nome: deve ser preenchido, diferente de branco e de null (2). deve ter entre 5 e 60 caracteres (3).
 * data de validade: deve ser maior do que a data atual mais 180 dias (4). 
 * valorUnitario: deve ser maior que zero (5). 
 * O método validar deve retornar null se o objeto estiver válido, e uma mensagem pertinente (ver abaixo)
 * se algum valor de atributo estiver inválido.
 * 
 * (1) - Identificador deve estar entre 100 e 1000000.
 * (2) - Nome deve ser preenchido.
 * (3) - Nome deve ter entre 10 e 100 caracteres.
 *
 * public String incluir(EntidadeOperadora entidade): deve chamar o método validar. Se ele 
 * retornar null, deve incluir entidade no repositório. Retornos possíveis:
 * (1) null, se o retorno do validar for null e o retorno do incluir do 
 * repositório for true.
 * (2) a mensagem retornada pelo validar, se o retorno deste for diferente
 * de null.
 * (3) A mensagem "Entidade já existente", se o retorno do validar for null
 * e o retorno do repositório for false. 
 *
 * public String alterar(EntidadeOperadora entidade): deve chamar o método validar. Se ele 
 * retornar null, deve alterar entidade no repositório. Retornos possíveis:
 * (1) null, se o retorno do validar for null e o retorno do alterar do 
 * repositório for true.
 * (2) a mensagem retornada pelo validar, se o retorno deste for diferente
 * de null.
 * (3) A mensagem "Entidade inexistente", se o retorno do validar for null
 * e o retorno do repositório for false.
 * 
 * public String excluir(int identificador): deve validar o identificador. 
 * Se este for válido, deve chamar o excluir do repositório. Retornos possíveis:
 * (1) null, se o retorno do excluir do repositório for true.
 * (2) A mensagem "Entidade inexistente", se o retorno do repositório for false
 * ou se o identificador for inválido.
 * 
 * public EntidadeOperadora buscar(int identificador): deve validar o identificador.
 * Se este for válido, deve chamar o buscar do repositório, retornando o 
 * que ele retornar. Se o identificador for inválido, retornar null. 
 */

public class MediatorEntidadeOperadora {

    private static MediatorEntidadeOperadora instancia;
    private RepositorioEntidadeOperadora repositorioEntidadeOperadora = new RepositorioEntidadeOperadora();

    public MediatorEntidadeOperadora() {

    }

    public MediatorEntidadeOperadora getInstancia() {
        if (instancia == null) {
            instancia = new MediatorEntidadeOperadora();
        }
        return instancia;
    }

    private String validar(EntidadeOperadora entidade) {
        if (entidade.getIdentificador() < 100 || entidade.getIdentificador() > 1000000) {
            return "Identificador deve estar entre 100 e 1000000.";
        }
        if (entidade.getNome() == null || entidade.getNome().trim().isEmpty()) {
            return "Nome deve ser preenchido.";
        }
        if (entidade.getNome().length() < 5 || entidade.getNome().length() > 60) {
            return "Nome deve ter entre 5 e 60 caracteres.";
        }
        return null;
    }

    public String incluir(EntidadeOperadora entidade) throws FileNotFoundException, IOException {
        String validacao = validar(entidade);
        if (validacao == null) {
            boolean sucesso = repositorioEntidadeOperadora.incluir(entidade);
            if(sucesso == true) {
            	return null;
            }else {
            	return "Entidade já existente";
            }
        } else {
            return validacao;
        }
    }

    public String alterar(EntidadeOperadora entidade) throws IOException {
        String validacao = validar(entidade);
        if (validacao == null) {
            boolean sucesso = repositorioEntidadeOperadora.alterar(entidade);
            if(sucesso == true) {
            	return null;
            }else {
            	return "Entidade inexistente";
            }
        } else {
            return validacao;
        }
    }

    public String excluir(int identificador) throws IOException {
        if (identificador < 100 || identificador > 1000000) {
            return "Entidade inexistente";
        }
        boolean sucesso = repositorioEntidadeOperadora.excluir(identificador);
        if(sucesso == true) {
        	return null;
        }else {
        	return "Entidade inexistente";
        }
    }

    public EntidadeOperadora buscar(int identificador) throws IOException {
        if (identificador < 100 || identificador > 1000000) {
            return null;
        }
        return repositorioEntidadeOperadora.buscar(identificador);
    }
}
