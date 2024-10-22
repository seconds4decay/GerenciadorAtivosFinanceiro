package br.com.cesarschool.poo.telas.entidadeoperadora;

import br.com.cesarschool.poo.titulos.mediators.MediatorEntidadeOperadora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TelaExcluirEntidadeOperadora {
    private JTextField textField1;
    private JPanel panel1;
    private JButton excluirButton;

    public TelaExcluirEntidadeOperadora() {
        panel1 = new JPanel();
        textField1 = new JTextField(20);
        excluirButton = new JButton("Excluir");

        JLabel idLabel = new JLabel("ID:");
        panel1.add(idLabel);
        panel1.add(textField1);
        panel1.add(excluirButton);

        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(textField1.getText());
                MediatorEntidadeOperadora mediator = new MediatorEntidadeOperadora();
                try {
                    String message = mediator.excluir(id);
                    if(message == null) {
                        message = "Entidade Operadora excluida com sucesso!";
                    }
                    JOptionPane.showMessageDialog(null, message);
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(excluirButton);
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
