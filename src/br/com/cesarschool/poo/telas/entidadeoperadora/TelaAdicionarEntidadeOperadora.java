package br.com.cesarschool.poo.telas.entidadeoperadora;

import br.com.cesarschool.poo.titulos.entidades.EntidadeOperadora;
import br.com.cesarschool.poo.titulos.mediators.MediatorEntidadeOperadora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TelaAdicionarEntidadeOperadora {
    private JPanel panel1;
    private JTextField idField1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton adicionarButton;

    public TelaAdicionarEntidadeOperadora() {
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MediatorEntidadeOperadora mediator = new MediatorEntidadeOperadora();
                long id = Long.parseLong(idField1.getText());
                String nome = textField1.getText();
                boolean autorizacao = Boolean.parseBoolean(textField2.getText());

                try {
                    String message = mediator.incluir(new EntidadeOperadora(id, nome, autorizacao));
                    if(message == null) {
                        message = "Entidade Operadora criada com sucesso!";
                    }
                    JOptionPane.showMessageDialog(null, message);
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(adicionarButton);
                    frame.dispose();
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
