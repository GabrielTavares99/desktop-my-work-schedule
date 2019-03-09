package view;

import myworktime.MarcacaoManager;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class MainView extends JFrame {


    public MainView() {

        MarcacaoManager marcacaoManager = MarcacaoManager.getInstance();

        BoxLayout boxLayout = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
        setLayout(boxLayout);

        setSize(300, 600);
        setResizable(false);
        setTitle("My Work Schedule");

        JButton jButton = new JButton("Marcar");
        jButton.setSize(100, 40);
        add(jButton);

        JLabel jLabel = new JLabel("f");
        jLabel.setSize(100, 40);
        add(jLabel);

        JLabel lblStatus = new JLabel("PARADO");
        lblStatus.setSize(100, 40);
        add(lblStatus);

        DefaultListModel<Object> objectDefaultListModel = new DefaultListModel<>();
        JList jList = new JList(objectDefaultListModel);
        JScrollPane jScrollPane = new JScrollPane(jList);
        jScrollPane.setPreferredSize(new Dimension(100, 100));
        add(jScrollPane);

        Thread thread = new Thread(new AtualizaTempo(jLabel, lblStatus));
        thread.start();

        jButton.addActionListener(e -> {
            marcacaoManager.fazerMarcacao();
            jList.removeAll();
            objectDefaultListModel.removeElement(marcacaoManager.getUltimaMarcacao());
            objectDefaultListModel.addElement(marcacaoManager.getUltimaMarcacao());
            long l = marcacaoManager.calcularTempoPorDia(LocalDate.now());
            lblStatus.setText(marcacaoManager.formataMinutosTrabalhadosEmHoras(l));

        });
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


}
