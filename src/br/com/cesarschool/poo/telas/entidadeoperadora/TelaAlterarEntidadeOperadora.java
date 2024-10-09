package br.com.cesarschool.poo.telas.entidadeoperadora;

import br.com.cesarschool.poo.titulos.entidades.EntidadeOperadora;
import br.com.cesarschool.poo.titulos.mediators.MediatorEntidadeOperadora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TelaAlterarEntidadeOperadora {
    private JTextField idField1;
    private JPanel panel1;
    private JTextField nameField2;
    private JTextField autorizacaoField;
    private JButton alterarButton;
    private JButton buscarButton;
    private JLabel saldoAcaoText;
    private JLabel saldoTituloDivida;
    private JTextArea preenchaApenasOIDTextArea;
    private JTextField textField1;
    private JButton creditarButton;
    private JButton debitarButton;

    public TelaAlterarEntidadeOperadora() {
        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField1.getText());
                String nome = nameField2.getText();
                boolean autorizacao = Boolean.parseBoolean(autorizacaoField.getText());

                MediatorEntidadeOperadora mediator = new MediatorEntidadeOperadora();
                try {
                    String message = mediator.alterar(new EntidadeOperadora(id, nome, autorizacao));
                    if(message == null) {
                        message = "Entidade Operadora alterada com sucesso!";
                    }
                    JOptionPane.showMessageDialog(null, message);
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(alterarButton);
                    frame.dispose();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MediatorEntidadeOperadora mediator = new MediatorEntidadeOperadora();
                int id = Integer.parseInt(idField1.getText());
                try {
                    EntidadeOperadora entidade = mediator.buscar(id);
                    if(entidade == null) {
                        JOptionPane.showMessageDialog(null, "Entidade Operadora não encontrada.");
                        return;
                    }
                    nameField2.setText(entidade.getNome());
                    autorizacaoField.setText(String.valueOf(entidade.getAutorizadoAcao()));
                    saldoAcaoText.setText("Saldo Ação:" + entidade.getSaldoAcao());
                    saldoTituloDivida.setText("Saldo Título Dívida:" + entidade.getSaldoTituloDivida());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
