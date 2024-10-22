package br.com.cesarschool.poo.telas.titulodivida;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCrudTituloDivida {

    private JButton adicionarButton;
    private JButton excluirButton;
    private JButton alterarButton;
    private JButton buscarButton;
    private JButton sairButton;
    private JPanel panel;
    
    public TelaCrudTituloDivida() {
    	adicionarButton = new JButton("Adicionar");
        excluirButton = new JButton("Excluir");
        alterarButton = new JButton("Alterar");
        buscarButton = new JButton("Buscar");
        sairButton = new JButton("Sair");

        panel = new JPanel();
        panel.add(adicionarButton);
        panel.add(excluirButton);
        panel.add(alterarButton);
        panel.add(buscarButton);
        panel.add(sairButton);
        
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame telaFrame = new JFrame();
                TelaIncluirTituloDivida tela = new TelaIncluirTituloDivida();
                JPanel painel = tela.getPanel1();
                configTela(telaFrame, painel, "Adicionar Título de dívida");
            }
        });
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame telaFrame = new JFrame();
                TelaExcluirTituloDivida tela = new TelaExcluirTituloDivida();
                JPanel painel = tela.getPanel1();
                configTela(telaFrame, painel, "Excluir Título de dívida");
            }
        });
        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame telaFrame = new JFrame();
                TelaAlterarTituloDivida tela = new TelaAlterarTituloDivida();
                JPanel painel = tela.getPanel1();
                configTela(telaFrame, painel, "Alterar Título de dívida");
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame telaFrame = new JFrame();
                TelaBuscarTituloDivida tela = new TelaBuscarTituloDivida();
                JPanel painel = tela.getPanel1();
                configTela(telaFrame, painel, "Buscar Título de dívida");
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
        TelaCrudTituloDivida tela = new TelaCrudTituloDivida();
        frame.getContentPane().add(tela.panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
