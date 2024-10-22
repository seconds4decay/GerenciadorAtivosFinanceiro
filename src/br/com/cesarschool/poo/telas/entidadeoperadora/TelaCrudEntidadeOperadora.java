package br.com.cesarschool.poo.telas.entidadeoperadora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCrudEntidadeOperadora {

    private JButton adicionarButton;
    private JButton excluirButton;
    private JButton alterarButton;
    private JButton buscarButton;
    private JButton sairButton;
    private JPanel panel;

    public TelaCrudEntidadeOperadora() {
        panel = new JPanel();
        adicionarButton = new JButton("Adicionar");
        excluirButton = new JButton("Excluir");
        alterarButton = new JButton("Alterar");
        buscarButton = new JButton("Buscar");
        sairButton = new JButton("Sair");

        panel.add(adicionarButton);
        panel.add(excluirButton);
        panel.add(alterarButton);
        panel.add(buscarButton);
        panel.add(sairButton);

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame telaFrame = new JFrame();
                TelaAdicionarEntidadeOperadora tela = new TelaAdicionarEntidadeOperadora();
                JPanel painel = tela.getPanel1();
                configTela(telaFrame, painel, "Adicionar Entidade Operadora");
            }
        });

        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame telaFrame = new JFrame();
                TelaExcluirEntidadeOperadora tela = new TelaExcluirEntidadeOperadora();
                JPanel painel = tela.getPanel1();
                configTela(telaFrame, painel, "Excluir Entidade Operadora");
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame telaFrame = new JFrame();
                TelaBuscarEntidadeOperadora tela = new TelaBuscarEntidadeOperadora();
                JPanel painel = tela.getPanel1();
                configTela(telaFrame, painel, "Buscar Entidade Operadora");
            }
        });

        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame telaFrame = new JFrame();
                TelaAlterarEntidadeOperadora tela = new TelaAlterarEntidadeOperadora();
                JPanel painel = tela.getPanel1();
                configTela(telaFrame, painel, "Alterar Entidade Operadora");
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
        tela.setSize(1400, 100);
        tela.setVisible(true);
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tela.setTitle(titulo);
    }

    public JPanel getPanel1() {
        return panel;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TelaCrudEntidadeOperadora tela = new TelaCrudEntidadeOperadora();
        frame.getContentPane().add(tela.panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 200);
        frame.setVisible(true);
    }
}
