package br.com.cesarschool.poo.telas.titulodivida;

import br.com.cesarschool.poo.titulos.entidades.TituloDivida;
import br.com.cesarschool.poo.titulos.mediators.MediatorTituloDivida;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;

public class TelaAlterarTituloDivida {
	private JTextField idField1;
    private JPanel panel1;
    private JTextField nameField2;
	private JTextField textField1;
	private JTextField textField2;
    private JButton alterarButton;
    private JButton buscarButton;
    private JLabel taxaTituloDividaText;
    
    public TelaAlterarTituloDivida() {
    	panel1 = new JPanel();
        idField1 = new JTextField(20);
        nameField2 = new JTextField(20);
        textField1 = new JTextField(20);
        textField2 = new JTextField(20);
        alterarButton = new JButton("Alterar");
        buscarButton = new JButton("Buscar");
        taxaTituloDividaText = new JLabel();

        // Adicionando JLabels para indicar os campos ao usuário
        JLabel idLabel = new JLabel("ID do Título:");
        JLabel nomeLabel = new JLabel("Nome:");
        JLabel dataLabel = new JLabel("Data (AAAA-MM-DD):");
        JLabel valorLabel = new JLabel("Valor:");

        // Adicionar componentes ao painel
        panel1.add(idLabel);
        panel1.add(idField1);
        panel1.add(buscarButton);
        panel1.add(nomeLabel);
        panel1.add(nameField2);
        panel1.add(dataLabel);
        panel1.add(textField1);
        panel1.add(valorLabel);
        panel1.add(textField2);
        panel1.add(taxaTituloDividaText);
        panel1.add(alterarButton);
    	alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField1.getText());
                String nome = nameField2.getText();
                LocalDate data = LocalDate.parse(textField1.getText());
                double valor = Double.parseDouble(textField2.getText());

                MediatorTituloDivida mediator = new MediatorTituloDivida();
                try {
                    String message = mediator.alterar(new TituloDivida(id, nome, data, valor));
                    if(message == null) {
                        message = "Título de dívida alterado com sucesso!";
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
                MediatorTituloDivida mediator = new MediatorTituloDivida();
                int id = Integer.parseInt(idField1.getText());
                try {
                    TituloDivida divida = mediator.buscar(id);
                    if(divida == null) {
                        JOptionPane.showMessageDialog(null, "Título de dívida não encontrado.");
                        return;
                    }
                    nameField2.setText(divida.getNome());
                    taxaTituloDividaText.setText("Taxa de juros:" + divida.getTaxaJuros());
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
