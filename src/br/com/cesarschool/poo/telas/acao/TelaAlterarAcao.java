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
    private JButton enviarButton;
    private JButton buscarButton;

    public TelaAlterarAcao() {
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
