package br.com.cesarschool.poo.telas.titulodivida;

import br.com.cesarschool.poo.titulos.mediators.MediatorTituloDivida;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TelaExcluirTituloDivida{
    private JTextField textField1;
    private JPanel panel1;
    private JButton excluirButton;

    public TelaExcluirTituloDivida() {
    	panel1 = new JPanel();
        textField1 = new JTextField(20);
        excluirButton = new JButton("Excluir");

     // Adicionando label para o campo de ID
        JLabel idLabel = new JLabel("ID do Título:");

        // Adicionando o label e o campo de texto ao painel
        panel1.add(idLabel);
        panel1.add(textField1);
        panel1.add(excluirButton);

        
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(textField1.getText());
                MediatorTituloDivida mediator = new MediatorTituloDivida();
                try {
                    String message = mediator.excluir(id);
                    if(message == null) {
                        message = "Título de dívida excluido com sucesso!";
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
