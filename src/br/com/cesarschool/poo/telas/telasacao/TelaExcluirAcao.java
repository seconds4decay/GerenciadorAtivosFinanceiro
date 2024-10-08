package br.com.cesarschool.poo.telas.telasacao;

import br.com.cesarschool.poo.titulos.mediators.MediatorAcao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TelaExcluirAcao {
    private JTextField textField1;
    private JPanel panel1;
    private JButton excluirButton;
    private JLabel idLabel;

    public TelaExcluirAcao() {
        MediatorAcao mediatorAcao = new MediatorAcao();
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(textField1.getText());
                try {
                    String message = mediatorAcao.excluir(id);
                    if(message == null) {
                        message = "Ação excluida com sucesso!";
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
