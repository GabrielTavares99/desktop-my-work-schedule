package managers;

import domain.Mark;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MarkManager {

    private static MarkManager markManager;
    private List<Mark> marcacoes = new ArrayList<>();
    private Mark ultimaMark = null;
    private boolean contando;
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private MarkManager() {

    }

    public static MarkManager getInstance() {
        if (markManager == null)
            return markManager = new MarkManager();
        return markManager;
    }

    public Mark getUltimaMark() {
        return ultimaMark;
    }

    public void fazerMarcacao() {
        if (ultimaMark == null || ultimaMark.getHoraFim() != null) {
            ultimaMark = new Mark(UUID.randomUUID().toString().substring(0, 4), LocalDateTime.now(), null);
            marcacoes.add(ultimaMark);
            contando = true;
        } else {
            ultimaMark.setHoraFim(LocalDateTime.now());
            contando = false;
        }
    }

    public long calcularTempoPorDia(LocalDate dataPesquisa) {
        List<Long> amount = new ArrayList<>();

        marcacoes.forEach(mark -> {
            if (mark.getHoraInicio().toLocalDate().isEqual(dataPesquisa)) {
                System.out.println("achou");
                amount.add(calculaTempo(mark.getHoraInicio(), mark.getHoraFim()));
            }
        });
        return amount.stream().mapToLong(Long::intValue).sum();
    }

    public String formataMinutosTrabalhadosEmHoras(long minutosTrabalhados) {
        String a = "%02d:%02d:%02d";
//        return String.format(a, TimeUnit.MINUTES.toHours(minutosTrabalhados), TimeUnit.MILLISECONDS.toMinutes(minutosTrabalhados) - TimeUnit.HOURS.toMinutes(
//                TimeUnit.MILLISECONDS.toHours(minutosTrabalhados)));
        long hours = minutosTrabalhados / 60; //since both are ints, you get an int
        long minutes = minutosTrabalhados % 60;
        long second = minutosTrabalhados / (24 * 3600);
        return String.format(a, hours, minutes, second);
    }

    public long calculaTempo(LocalDateTime inicio, LocalDateTime fim) {
        if (fim == null)
            fim = LocalDateTime.now();
        long between = ChronoUnit.MINUTES.between(inicio, fim);
        System.out.println(between);
        return between;
    }

    public void listar() {
        marcacoes.forEach(mark -> {
            String s = mark.getHoraFim() == null ? null : mark.getHoraFim().format(dateTimeFormatter);
            System.out.println(mark.getDescricao() + " " + mark.getHoraInicio().format(dateTimeFormatter) + " " + s);
        });
    }

    public List<Mark> getMarcacoes() {
        return marcacoes;
    }

    public void setMarcacoes(List<Mark> marcacoes) {
        this.marcacoes = marcacoes;
    }

    public boolean isContando() {
        return contando;
    }
}
