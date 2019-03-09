package view;


import managers.MarkManager;

import javax.swing.*;
import java.time.LocalDate;

public class AtualizaTempo implements Runnable {

    private JLabel lblCurrentTime;
    private JLabel lblStatus;
    private MarkManager markManager = MarkManager.getInstance();

    public AtualizaTempo(JLabel lblCurrentTime, JLabel lblStatus) {
        this.lblCurrentTime = lblCurrentTime;
        this.lblStatus = lblStatus;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (markManager.isContando()) {
                    lblStatus.setText("CONTANDO");
                } else {
                    lblStatus.setText("PARADO");
                }
                long l = markManager.calcularTempoPorDia(LocalDate.now());
                lblCurrentTime.setText(markManager.formataMinutosTrabalhadosEmHoras(l));
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
