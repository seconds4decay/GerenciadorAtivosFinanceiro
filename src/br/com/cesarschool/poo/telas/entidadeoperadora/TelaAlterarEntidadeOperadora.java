package br.com.cesarschool.poo.telas.entidadeoperadora;

import br.com.cesarschool.poo.titulos.entidades.EntidadeOperadora;
import br.com.cesarschool.poo.titulos.mediators.MediatorEntidadeOperadora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Array;

public class TelaAlterarEntidadeOperadora {
    private JTextField idField1;
    private JPanel panel1;
    private JTextField nameField2;
    private JButton alterarButton;
    private JButton buscarButton;
    private JLabel saldoAcaoText;
    private JLabel saldoTituloDivida;
    private JTextArea preenchaApenasOIDTextArea;
    private JComboBox comboBox1;
    private String[] options = {"true", "false"};


    public TelaAlterarEntidadeOperadora() {
        panel1 = new JPanel();
        idField1 = new JTextField(20);
        nameField2 = new JTextField(20);
        comboBox1 = new JComboBox(options);
        alterarButton = new JButton("Alterar");
        buscarButton = new JButton("Buscar");
        saldoAcaoText = new JLabel("Saldo Ação:");
        saldoTituloDivida = new JLabel("Saldo Título Dívida:");
        preenchaApenasOIDTextArea = new JTextArea("Preencha apenas o ID para buscar a entidade operadora.");

        JLabel idLabel = new JLabel("ID:");
        JLabel nomeLabel = new JLabel("Nome:");
        JLabel autorizacaoLabel = new JLabel("Autorização da Ação:");


        panel1.add(preenchaApenasOIDTextArea);
        panel1.add(idLabel);
        panel1.add(idField1);
        panel1.add(nomeLabel);
        panel1.add(nameField2);
        panel1.add(autorizacaoLabel);
        panel1.add(comboBox1);
        panel1.add(alterarButton);
        panel1.add(buscarButton);
        panel1.add(saldoAcaoText);
        panel1.add(saldoTituloDivida);


        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField1.getText());
                String nome = nameField2.getText();
                boolean autorizacao = Boolean.parseBoolean(comboBox1.getSelectedItem().toString());

                MediatorEntidadeOperadora mediator = new MediatorEntidadeOperadora();
                try {
                    String message = mediator.alterar(new EntidadeOperadora(id, nome, 100));
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
                    comboBox1.setSelectedItem(entidade.getAutorizadoAcao() ? "true" : "false");
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
