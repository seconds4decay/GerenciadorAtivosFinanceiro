package br.com.cesarschool.poo.telas.acao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCrudAcao {
    private JButton adicionarButton;
    private JButton excluirButton;
    private JButton alterarButton;
    private JButton buscarButton;
    private JPanel panel1;
    private JButton sairButton;

    public TelaCrudAcao() {
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame tela = new JFrame();
                TelaAdicionarAcao telaAdicionar = new TelaAdicionarAcao();
                JPanel painel = telaAdicionar.getPanel1();
                configTela(tela, painel, "Adicionar Ação");
            }
        });

        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame tela = new JFrame();
                TelaExcluirAcao telaExcluir = new TelaExcluirAcao();
                JPanel painel = telaExcluir.getPanel1();
                configTela(tela, painel, "Excluir Ação");
            }
        });

        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame tela = new JFrame();
                TelaAlterarAcao telaAlterar = new TelaAlterarAcao();
                telaAlterar.getPanel1();
                JPanel painel = telaAlterar.getPanel1();
                configTela(tela, painel, "Alterar Ação");
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame tela = new JFrame();
                TelaBuscarAcao telaBuscar = new TelaBuscarAcao();
                JPanel painel = telaBuscar.getPanel1();
                configTela(tela, painel, "Buscar Ação");
            }
        });

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(sairButton);
                frame.dispose();
            }
        });
    }

    private void configTela(JFrame tela, JPanel painel, String titulo) {
        tela.add(painel);
        tela.pack();
        tela.setLocationRelativeTo(null);
        tela.setSize(700, 400);
        tela.setVisible(true);
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tela.setTitle(titulo);
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TelaCrudAcao tela = new TelaCrudAcao();
        frame.getContentPane().add(tela.panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 200);
        frame.setVisible(true);
    }
}
