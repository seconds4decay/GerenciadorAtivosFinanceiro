package br.com.cesarschool.poo.telas.entidadeoperadora;

import br.com.cesarschool.poo.titulos.entidades.EntidadeOperadora;
import br.com.cesarschool.poo.titulos.mediators.MediatorEntidadeOperadora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TelaBuscarEntidadeOperadora {
    private JLabel idField;
    private JTextField buscarTextField;
    private JButton buscarButton;
    private JPanel panel1;

    public TelaBuscarEntidadeOperadora() {
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MediatorEntidadeOperadora mediator = new MediatorEntidadeOperadora();
                int id = Integer.parseInt(buscarTextField.getText());
                try {
                    EntidadeOperadora entidade = mediator.buscar(id);
                    if (entidade == null) {
                        JOptionPane.showMessageDialog(null, "Entidade Operadora não encontrada.");
                        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(buscarButton);
                        frame.dispose();
                    } else {
                        infoFrame(entidade);
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void infoFrame(EntidadeOperadora entidade) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        JLabel nome = new JLabel();
        nome.setText("Nome: " + entidade.getNome());

        JLabel autorizacao = new JLabel();
        autorizacao.setText("Autorização Ação: " + entidade.getAutorizadoAcao());

        JLabel saldo1 = new JLabel();
        saldo1.setText("Saldo Ação: "+ entidade.getSaldoAcao());

        JLabel saldo2 = new JLabel();
        saldo2.setText("Saldo Título Dívida: "+ entidade.getSaldoTituloDivida());

        frame.setTitle("Entidade Operadora");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.add(panel);
        panel.setLayout(null);

        nome.setBounds(10, 10, 200, 25);
        autorizacao.setBounds(10, 40, 200, 25);
        saldo1.setBounds(10, 70, 200, 25);
        saldo2.setBounds(10, 100, 200, 25);

        panel.add(nome);
        panel.add(autorizacao);
        panel.add(saldo1);
        panel.add(saldo2);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
