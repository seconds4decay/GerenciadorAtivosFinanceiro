package br.com.cesarschool.poo.telas;

import br.com.cesarschool.poo.telas.acao.TelaCrudAcao;
import br.com.cesarschool.poo.telas.entidadeoperadora.TelaCrudEntidadeOperadora;
import br.com.cesarschool.poo.telas.operacao.TelaOperacao;
import br.com.cesarschool.poo.telas.titulodivida.TelaBuscarTituloDivida;
import br.com.cesarschool.poo.telas.titulodivida.TelaCrudTituloDivida;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaMenuPrincipal {
    private JButton acoesButton;
    private JButton entidadesOperadorasButton;
    private JButton titulosDividasButton;
    private JButton operacoesButton;
    private JPanel panel;

    public TelaMenuPrincipal() {
        acoesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame telaFrame = new JFrame();
                TelaCrudAcao tela = new TelaCrudAcao();
                JPanel painel = tela.getPanel1();
                configTela(telaFrame, painel, "Ações");
            }
        });
        entidadesOperadorasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame telaFrame = new JFrame();
                TelaCrudEntidadeOperadora tela = new TelaCrudEntidadeOperadora();
                JPanel painel = tela.getPanel1();
                configTela(telaFrame, painel, "Entidades Operadoras");

            }
        });
        titulosDividasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame telaFrame = new JFrame();
                TelaCrudTituloDivida tela = new TelaCrudTituloDivida();
                JPanel painel = tela.getPanel1();
                configTela(telaFrame, painel, "Títulos de Dívida");

            }
        });
        operacoesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame telaFrame = new JFrame();
                TelaOperacao tela = new TelaOperacao();
                JPanel painel = tela.getPanel1();
                configTela(telaFrame, painel, "Operações");
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

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TelaMenuPrincipal tela = new TelaMenuPrincipal();
        frame.getContentPane().add(tela.panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
