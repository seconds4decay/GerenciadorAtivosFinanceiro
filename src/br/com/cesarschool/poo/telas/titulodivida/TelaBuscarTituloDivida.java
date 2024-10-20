package br.com.cesarschool.poo.telas.titulodivida;
import java.io.IOException;

import br.com.cesarschool.poo.titulos.entidades.TituloDivida;
import br.com.cesarschool.poo.titulos.mediators.MediatorTituloDivida;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TelaBuscarTituloDivida {

    private JPanel panel;
    private JTextField textField1;
    private JButton buscarButton;

    public TelaBuscarTituloDivida() {
    	panel = new JPanel();
        textField1 = new JTextField(20);
        buscarButton = new JButton("Buscar");

     // Adicionar um JLabel para indicar o campo de ID
        JLabel idLabel = new JLabel("ID do Título:");

        // Adicionar componentes ao painel
        panel.add(idLabel);  // Adiciona o JLabel para indicar o campo
        panel.add(textField1);
        panel.add(buscarButton);
        
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MediatorTituloDivida mediatorTituloDivida = new MediatorTituloDivida();
                int id = Integer.parseInt(textField1.getText());
                try {
                    TituloDivida tituloDivida = mediatorTituloDivida.buscar(id);
                    if (tituloDivida == null) {
                        JOptionPane.showMessageDialog(null, "Título de dívida não encontrado.");
                        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(buscarButton);
                        frame.dispose();
                    } else {
                        infoFrame(tituloDivida);
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public JPanel getPanel1() {
        return panel;
    }

    public void infoFrame(TituloDivida tituloDivida) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        JLabel nome = new JLabel();
        nome.setText("Nome: " + tituloDivida.getNome());

        JLabel taxa = new JLabel();
        taxa.setText("Taxa de juros: " + tituloDivida.getTaxaJuros());
        
        frame.setTitle("Título de dívida");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.add(panel);
        panel.setLayout(null);

        nome.setBounds(10, 10, 200, 25);
        taxa.setBounds(10, 40, 200, 25);

        panel.add(nome);
        panel.add(taxa);

        frame.pack();
        frame.setLocation(500, 200);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
