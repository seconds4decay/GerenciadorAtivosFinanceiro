package br.gov.cesarschool.poo.daogenerico;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DAOSerializadorObjetos {
    private String nomeDiretorio;

    public DAOSerializadorObjetos(Class<?> tipoEntidade) {
        this.nomeDiretorio = "." + File.separator + tipoEntidade.getSimpleName();
    }

    public boolean incluir(Entidade entidade) {
        File diretorio = new File(nomeDiretorio + File.separator);
        if (!diretorio.exists()) {
            diretorio.mkdirs();
        }

        String idUnico = entidade.getIdUnico();
        File arquivo = new File(diretorio, idUnico);

        if (arquivo.exists()) {
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


    public boolean alterar(Entidade entidade) {
        File diretorio = new File(nomeDiretorio + File.separator);
        if (!diretorio.exists() || !diretorio.isDirectory()) {
            return false;
        }

        Entidade e = buscar(entidade.getIdUnico());

        if(e == null) return false;

        File arquivo = new File(diretorio, e.getIdUnico());

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            if (e.getIdUnico().equals(entidade.getIdUnico())) {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
                    oos.writeObject(entidade);
                    return true;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public boolean excluir(String idUnico) {
        File diretorio = new File(nomeDiretorio + File.separator);
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

    public Entidade buscar(String idUnico) {
        Entidade[] entidades = buscarTodos();
        for (Entidade e : entidades) {
            if (e.getIdUnico().equals(idUnico)) {
                return e;
            }
        }
        return null;
    }

    public Entidade[] buscarTodos() {
        File diretorio = new File(nomeDiretorio + File.separator);
        if (!diretorio.exists() || !diretorio.isDirectory()) {
            return new Entidade[0];
        }

        List<Entidade> entidades = new ArrayList<>();
        File[] arquivos = diretorio.listFiles();

        if(arquivos == null) {
            return new Entidade[0];
        }

        for (File arquivo : arquivos) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
                Entidade entidade = (Entidade) ois.readObject();
                entidades.add(entidade);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return entidades.toArray(new Entidade[0]);
    }
}
