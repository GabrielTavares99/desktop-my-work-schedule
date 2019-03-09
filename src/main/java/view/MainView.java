package view;


import managers.MarkManager;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class MainView extends JFrame {


    public MainView() {

        MarkManager markManager = MarkManager.getInstance();

        BoxLayout boxLayout = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
        setLayout(boxLayout);

        setSize(330, 600);
        setResizable(false);
        setTitle("My Work Schedule");

        JButton btnMark = new JButton("Marcar");
        btnMark.setSize(100, 40);
        add(btnMark);

        JLabel lblCurrentTime = new JLabel("00:00:00");
        lblCurrentTime.setSize(100, 40);
        add(lblCurrentTime);

        JLabel lblStatus = new JLabel("PARADO");
        lblStatus.setSize(100, 40);
        add(lblStatus);

        DefaultListModel<Object> objectDefaultListModel = new DefaultListModel<>();
        JList jList = new JList(objectDefaultListModel);
        JScrollPane jScrollPane = new JScrollPane(jList);
        jScrollPane.setPreferredSize(new Dimension(100, 100));
        add(jScrollPane);

        Thread thread = new Thread(new AtualizaTempo(lblCurrentTime, lblStatus));
        thread.start();

        btnMark.addActionListener(e -> {
            markManager.fazerMarcacao();
            jList.removeAll();
            objectDefaultListModel.removeElement(markManager.getLastMark());
            objectDefaultListModel.addElement(markManager.getLastMark());
            double l = markManager.getTotalTimeBySpecificDate(LocalDate.now());
            lblStatus.setText(markManager.formatSecondsIntoHHMMSS(l));

        });
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


}
