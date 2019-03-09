package domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.StringJoiner;

public class Marcacao {

    private LocalDateTime horaInicio;
    private String descricao;
    private LocalDateTime horaFim;
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public Marcacao(String descricao, LocalDateTime horaInicio, LocalDateTime horaFim) {
        this.horaInicio = horaInicio;
        this.descricao = descricao;
        this.horaFim = horaFim;
    }

    public LocalDateTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalDateTime horaFim) {
        this.horaFim = horaFim;
    }

    public LocalDateTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalDateTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        StringJoiner stringBuilder = new StringJoiner(" ");
        stringBuilder.add(descricao);
        stringBuilder.add(horaInicio.format(dateTimeFormatter));
        if (horaFim != null)
            stringBuilder.add(horaFim.format(dateTimeFormatter));
        return stringBuilder.toString();
    }
}
