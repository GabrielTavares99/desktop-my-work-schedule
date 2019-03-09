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
    private List<Mark> marks = new ArrayList<>();
    private Mark lastMark = null;
    private boolean timeRunning;
    private DateTimeFormatter dateTimeFormatterPattern = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private MarkManager() {

    }

    public static MarkManager getInstance() {
        if (markManager == null)
            return markManager = new MarkManager();
        return markManager;
    }

    public Mark getLastMark() {
        return lastMark;
    }

    public void fazerMarcacao() {
        if (lastMark == null || lastMark.getEndDateTime() != null) {
            lastMark = new Mark(UUID.randomUUID().toString().substring(0, 4), LocalDateTime.now(), null);
            marks.add(lastMark);
            timeRunning = true;
        } else {
            lastMark.setEndDateTime(LocalDateTime.now());
            timeRunning = false;
        }
    }

    public double getTotalTimeBySpecificDate(LocalDate dataPesquisa) {
        List<Long> amount = new ArrayList<>();

        marks.forEach(mark -> {
            if (mark.getStartDateTime().toLocalDate().isEqual(dataPesquisa)) {
                amount.add(calculaTempo(mark.getStartDateTime(), mark.getEndDateTime()));
            }
        });
        return amount.stream().mapToLong(Long::intValue).sum();
    }

    public String formatSecondsIntoHHMMSS(double spentSeconds) {
        String a = "%02d:%02d:%02d";
        int hours = (int) spentSeconds / 3600;
        int remainder = (int) spentSeconds - hours * 3600;
        int minutes = remainder / 60;
        remainder = remainder - minutes * 60;
        int seconds = remainder;
        return String.format(a, hours, minutes, seconds);
    }

    public long calculaTempo(LocalDateTime inicio, LocalDateTime fim) {
        if (fim == null)
            fim = LocalDateTime.now();
        return ChronoUnit.SECONDS.between(inicio, fim);
    }

    public void listar() {
        marks.forEach(mark -> {
            String s = mark.getEndDateTime() == null ? null : mark.getEndDateTime().format(dateTimeFormatterPattern);
            System.out.println(mark.getDescription() + " " + mark.getStartDateTime().format(dateTimeFormatterPattern) + " " + s);
        });
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }

    public boolean isTimeRunning() {
        return timeRunning;
    }
}
