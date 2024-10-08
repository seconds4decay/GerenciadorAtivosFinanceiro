package br.com.cesarschool.poo.telas.telasacao;

import br.com.cesarschool.poo.titulos.entidades.Acao;
import br.com.cesarschool.poo.titulos.mediators.MediatorAcao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TelaBuscarAcao {

    private JPanel panel;
    private JTextField textField1;
    private JButton buscarButton;

    public TelaBuscarAcao() {
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MediatorAcao mediatorAcao = new MediatorAcao();
                int id = Integer.parseInt(textField1.getText());
                try {
                    Acao acao = mediatorAcao.buscar(id);
                    if (acao == null) {
                        JOptionPane.showMessageDialog(null, "Ação não encontrada.");
                        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(buscarButton);
                        frame.dispose();
                    } else {
                        infoFrame(acao);
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

    public void infoFrame(Acao acao) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        JLabel nome = new JLabel();
        nome.setText("Nome: " + acao.getNome());

        JLabel data = new JLabel();
        data.setText("Data: " + acao.getDataValidade().toString());

        JLabel valorUnitario = new JLabel();
        valorUnitario.setText("Valor Unitario: " + acao.getValorUnitario());

        frame.setTitle("Ação");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.add(panel);
        panel.setLayout(null);

        nome.setBounds(10, 10, 200, 25);
        data.setBounds(10, 40, 200, 25);
        valorUnitario.setBounds(10, 70, 200, 25);

        panel.add(nome);
        panel.add(data);
        panel.add(valorUnitario);

        frame.pack();
        frame.setLocation(500, 200);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
