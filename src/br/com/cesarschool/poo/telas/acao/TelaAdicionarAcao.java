package br.com.cesarschool.poo.telas.acao;

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
    	panel1 = new JPanel();
    	nomeField1 = new JTextField(20);
    	idField1 = new JTextField(20);
    	textField1 = new JTextField(20);
    	textField2 = new JTextField(20);
    	enviarButton = new JButton("Enviar");
    	
    	JLabel idLabel = new JLabel("ID:");
        JLabel nomeLabel = new JLabel("Nome:");
        JLabel dataLabel = new JLabel("Data (YYYY-MM-DD):");
        JLabel valorLabel = new JLabel("Valor:");
    	
    	nomeField1.setBounds(10, 10, 10, 10);
    	idField1.setBounds(20, 20, 200, 200);
    	panel1.add(nomeLabel);
        panel1.add(nomeField1);
        panel1.add(idLabel);
        panel1.add(idField1);
        panel1.add(dataLabel);
        panel1.add(textField1);
        panel1.add(valorLabel);
        panel1.add(textField2);
        panel1.add(enviarButton);
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
