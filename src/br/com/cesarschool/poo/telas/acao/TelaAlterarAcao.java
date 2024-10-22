package br.com.cesarschool.poo.telas.acao;

import br.com.cesarschool.poo.titulos.entidades.Acao;
import br.com.cesarschool.poo.titulos.mediators.MediatorAcao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;

public class TelaAlterarAcao {
    private JPanel panel;
    private JTextField idField1;
    private JTextField nomeField1;
    private JTextField dataField1;
    private JTextField valorField2;
    private JTextPane textoPane;
    private JButton enviarButton;
    private JButton buscarButton;

    public TelaAlterarAcao() {
    	panel = new JPanel();
        idField1 = new JTextField(20);
        nomeField1 = new JTextField(20);
        dataField1 = new JTextField(20);
        valorField2 = new JTextField(20);
        textoPane = new JTextPane();
        enviarButton = new JButton("Enviar");
        buscarButton = new JButton("Buscar");

        JLabel idLabel = new JLabel("ID:");
        JLabel nomeLabel = new JLabel("Nome:");
        JLabel dataLabel = new JLabel("Data (YYYY-MM-DD):");
        JLabel valorLabel = new JLabel("Valor:");
        JLabel textoLabel = new JLabel("Texto Adicional:");

        idField1.setBounds(10, 10, 10, 10);
        nomeField1.setBounds(20, 20, 200, 200);

        panel.add(idLabel);
        panel.add(idField1);
        panel.add(nomeLabel);
        panel.add(nomeField1);
        panel.add(dataLabel);
        panel.add(dataField1);
        panel.add(valorLabel);
        panel.add(valorField2);
        panel.add(textoLabel);
        panel.add(textoPane);
        panel.add(enviarButton);
        panel.add(buscarButton);
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MediatorAcao acao = new MediatorAcao();
                int id = Integer.parseInt(idField1.getText());
                try {
                    Acao acao1 = acao.buscar(id);

                    if(acao1 != null) {
                        nomeField1.setText(acao1.getNome());
                        dataField1.setText(acao1.getDataValidade().toString());
                        valorField2.setText(String.valueOf(acao1.getValorUnitario()));
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MediatorAcao acao = new MediatorAcao();
                int id = Integer.parseInt(idField1.getText());
                String nome = nomeField1.getText();
                LocalDate data = LocalDate.parse(dataField1.getText());
                double valor = Double.parseDouble(valorField2.getText());

                Acao novaAcao = new Acao(id, nome, data, valor);

                try {
                    String message = acao.alterar(novaAcao);
                    if(message != null) {
                        JOptionPane.showMessageDialog(null, message);
                    } else {
                        message = "Ação alterada com sucesso!";
                        JOptionPane.showMessageDialog(null, message);
                    }
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(enviarButton);
                    frame.dispose();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public JPanel getPanel1() {
        return panel;
    }
}
