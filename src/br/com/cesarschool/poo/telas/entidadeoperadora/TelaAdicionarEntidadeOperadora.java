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
    private JButton adicionarButton;
    private JComboBox comboBox1;
    private String[] options = {"true", "false"};

    public TelaAdicionarEntidadeOperadora() {
        panel1 = new JPanel();
        idField1 = new JTextField(20);
        textField1 = new JTextField(20);
        comboBox1 = new JComboBox(options);
        adicionarButton = new JButton("Enviar");

        JLabel idLabel = new JLabel("ID:");
        JLabel nomeLabel = new JLabel("Nome:");
        JLabel dataLabel = new JLabel("Autorização da Ação::");

        idField1.setBounds(20, 20, 200, 200);
        panel1.add(idLabel);
        panel1.add(idField1);
        panel1.add(nomeLabel);
        panel1.add(textField1);
        panel1.add(dataLabel);
        panel1.add(comboBox1);
        panel1.add(adicionarButton);

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MediatorEntidadeOperadora mediator = new MediatorEntidadeOperadora();
                long id = Long.parseLong(idField1.getText());
                String nome = textField1.getText();
                boolean autorizacao = Boolean.parseBoolean(comboBox1.getSelectedItem().toString());

                try {
                    String message = mediator.incluir(new EntidadeOperadora(id, nome, 100));
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
