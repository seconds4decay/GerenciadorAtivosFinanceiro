package br.com.cesarschool.poo.telas.telasacao;

import br.com.cesarschool.poo.titulos.entidades.Acao;
import br.com.cesarschool.poo.titulos.mediators.MediatorAcao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;

public class TelaAdicionarAcao {
    private JPanel panel1;
    private JTextField nomeField1;
    private JTextField idField1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton enviarButton;

    public TelaAdicionarAcao() {
        MediatorAcao mediatorAcao = new MediatorAcao();

        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField1.getText());
                String nome = nomeField1.getText();
                LocalDate data = LocalDate.parse(textField1.getText());
                double valor = Double.parseDouble(textField2.getText());

                try {
                    String message = mediatorAcao.incluir(new Acao(id, nome, data, valor));

                    if(message == null) {
                        message = "Ação cadastrada com sucesso!";
                    }
                    JOptionPane.showMessageDialog(null, message);
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(enviarButton);
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
