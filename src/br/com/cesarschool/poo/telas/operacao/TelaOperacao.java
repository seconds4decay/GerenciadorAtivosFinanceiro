package br.com.cesarschool.poo.telas.operacao;

import javax.swing.*;
import br.com.cesarschool.poo.titulos.mediators.MediatorOperacao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TelaOperacao{
    
    private JPanel panel;
    private JTextField textField1; // ID
    private JTextField textField2; // Crédito
    private JTextField textField3; // Débito
    private JTextField textField4; // Valor
    private JButton realizarButton;

    public TelaOperacao() {
        panel = new JPanel();
        textField1 = new JTextField(20);
        textField2 = new JTextField(20);
        textField3 = new JTextField(20);
        textField4 = new JTextField(20);

        realizarButton = new JButton("Realizar Operação");

        JLabel credito = new JLabel("Crédito:");
        JLabel debito = new JLabel("Débito:");
        JLabel idLabel = new JLabel("ID:");
        JLabel valor = new JLabel("Valor:");
        
        panel.add(credito); 
        panel.add(textField2); 
        panel.add(debito);
        panel.add(textField3);
        panel.add(idLabel);
        panel.add(textField1); 
        panel.add(valor);
        panel.add(textField4); 
        panel.add(realizarButton);
        
        // Usando o singleton
        MediatorOperacao mediatorOperacao = MediatorOperacao.getInstance();
        
        realizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {    
                try {
                    // Obtenha os dados dos campos de texto
                    int id = Integer.parseInt(textField1.getText());
                    int credito = Integer.parseInt(textField2.getText());
                    int debito = Integer.parseInt(textField3.getText());
                    double valor = Double.parseDouble(textField4.getText());

                    // Chame o método de realizar operação
                    String message = mediatorOperacao.realizarOperacao(true, credito, debito, id, valor);

                    if(message == null) {
                        message = "Operação realizada com sucesso!";
                    }
                    JOptionPane.showMessageDialog(null, message);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro: Verifique se os valores estão corretos.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Erro de I/O: " + ex.getMessage());
                }
            }
        });
    }

    public JPanel getPanel1() {
        return panel;
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TelaOperacao tela = new TelaOperacao();
        frame.getContentPane().add(tela.panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
