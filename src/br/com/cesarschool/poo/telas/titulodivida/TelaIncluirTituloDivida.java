package br.com.cesarschool.poo.telas.titulodivida;

import br.com.cesarschool.poo.titulos.entidades.TituloDivida;
import br.com.cesarschool.poo.titulos.mediators.MediatorTituloDivida;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;

public class TelaIncluirTituloDivida {
	 private JPanel panel1;
	 private JTextField nomeField1;
	 private JTextField idField1;
	 private JTextField textField1;
	 private JTextField textField2;
	 private JButton enviarButton;
	
	public TelaIncluirTituloDivida() {
		panel1 = new JPanel();
	    nomeField1 = new JTextField(20);
	    idField1 = new JTextField(20);
	    textField1 = new JTextField(20);
	    textField2 = new JTextField(20);
	    enviarButton = new JButton("Enviar");
	   
	 // Adicionando labels para cada campo de entrada
        JLabel idLabel = new JLabel("ID:");
        JLabel nomeLabel = new JLabel("Nome:");
        JLabel dataLabel = new JLabel("Data (YYYY-MM-DD):");
        JLabel valorLabel = new JLabel("Valor:");

        // Adicionando os componentes ao painel
        panel1.add(idLabel);
        panel1.add(idField1);
        panel1.add(nomeLabel);
        panel1.add(nomeField1);
        panel1.add(dataLabel);
        panel1.add(textField1);
        panel1.add(valorLabel);
        panel1.add(textField2);
        panel1.add(enviarButton);
		MediatorTituloDivida mediatorTituloDivida = new MediatorTituloDivida();
		
		enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField1.getText());
                String nome = nomeField1.getText();
                LocalDate data = LocalDate.parse(textField1.getText());
                double valor = Double.parseDouble(textField2.getText());

                try {
                    String message = mediatorTituloDivida.incluir(new TituloDivida(id, nome, data, valor));

                    if(message == null) {
                        message = "Título de vida cadastrado com sucesso!";
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
