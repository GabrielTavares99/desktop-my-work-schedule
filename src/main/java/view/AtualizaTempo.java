package view;

import myworktime.MarcacaoManager;

import javax.swing.*;
import java.time.LocalDate;

public class AtualizaTempo implements Runnable {

    private JLabel jLabel;
    private JLabel lblStatus;
    private MarcacaoManager marcacaoManager = MarcacaoManager.getInstance();

    public AtualizaTempo(JLabel lblTempo, JLabel lblStatus) {
        this.jLabel = lblTempo;
        this.lblStatus = lblStatus;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (marcacaoManager.isContando()){
                    lblStatus.setText("CONTANDO");
                }else {
                    lblStatus.setText("PARADO");
                }
                long l = marcacaoManager.calcularTempoPorDia(LocalDate.now());
                jLabel.setText(marcacaoManager.formataMinutosTrabalhadosEmHoras(l));
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
