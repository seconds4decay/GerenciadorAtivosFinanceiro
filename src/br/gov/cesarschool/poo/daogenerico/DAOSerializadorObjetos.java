package br.gov.cesarschool.poo.daogenerico;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DAOSerializadorObjetos<T extends Entidade> {
    private String nomeArquivo;

    public DAOSerializadorObjetos(Class<T> classe) {
        this.nomeArquivo = "." + File.separator + classe.getSimpleName();
    }

    public boolean incluir(T entidade) {
        List<T> entidades = new ArrayList<>(List.of(buscarTodos()));

        File diretorio = new File(nomeArquivo + File.separator);
        if (!diretorio.exists()) {
            diretorio.mkdirs();
        }

        String idUnico = entidade.getIdUnico();
        File arquivo = new File(diretorio, idUnico);

        if (arquivo.exists()) {
            System.out.println("Arquivo já existe: " + arquivo.getName());
            return false;
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(entidade);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean alterar(T entidade) {
        File diretorio = new File(nomeArquivo + File.separator);
        if (!diretorio.exists() || !diretorio.isDirectory()) {
            return false;
        }

        File[] arquivos = diretorio.listFiles();
        if (arquivos != null) {
            for (File arquivo : arquivos) {
                if (arquivo.isFile()) {
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
                        T existingEntity = (T) ois.readObject();
                        if (existingEntity.getIdUnico().equals(entidade.getIdUnico())) {
                            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
                                oos.writeObject(entidade);
                                return true;
                            }
                        }
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return false;
    }

    public boolean excluir(String idUnico) {
        File diretorio = new File(nomeArquivo + File.separator);
        if (!diretorio.exists() || !diretorio.isDirectory()) {
            return false;
        }

        File[] arquivos = diretorio.listFiles();
        if (arquivos != null) {
            for (File arquivo : arquivos) {
                if (arquivo.isFile() && arquivo.getName().equals(idUnico)) {
                    return arquivo.delete();
                }
            }
        }
        return false;
    }

    public T buscar(String idUnico) {
        T[] entidades = buscarTodos();
        for (T e : entidades) {
            if (e.getIdUnico().equals(idUnico)) {
                return e;
            }
        }
        return null;
    }

    public T[] buscarTodos() {
        File diretorio = new File(nomeArquivo + File.separator);
        if (!diretorio.exists() || !diretorio.isDirectory()) {
            return (T[]) java.lang.reflect.Array.newInstance(Entidade.class, 0);
        }

        List<T> entidades = new ArrayList<>();
        File[] arquivos = diretorio.listFiles();
        if (arquivos != null) {
            for (File arquivo : arquivos) {
                if (arquivo.isFile()) {
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
                        T entidade = (T) ois.readObject();
                        entidades.add(entidade);
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return entidades.toArray((T[]) new Entidade[0]);
    }
}
