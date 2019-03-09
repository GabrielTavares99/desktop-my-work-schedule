import myworktime.domain.Marcacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MarcacaoManager {

    private static MarcacaoManager marcacaoManager;
    private List<Marcacao> marcacoes = new ArrayList<>();
    private Marcacao ultimaMarcacao = null;
    private boolean contando;
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private MarcacaoManager() {

    }

    public static MarcacaoManager getInstance() {
        if (marcacaoManager == null)
            return marcacaoManager = new MarcacaoManager();
        return marcacaoManager;
    }

    public Marcacao getUltimaMarcacao() {
        return ultimaMarcacao;
    }

    public void fazerMarcacao() {
        if (ultimaMarcacao == null || ultimaMarcacao.getHoraFim() != null) {
            ultimaMarcacao = new Marcacao(UUID.randomUUID().toString().substring(0, 4), LocalDateTime.now(), null);
            marcacoes.add(ultimaMarcacao);
            contando = true;
        } else {
            ultimaMarcacao.setHoraFim(LocalDateTime.now());
            contando = false;
        }
    }

    public long calcularTempoPorDia(LocalDate dataPesquisa) {
        List<Long> amount = new ArrayList<>();

        marcacoes.forEach(marcacao -> {
            if (marcacao.getHoraInicio().toLocalDate().isEqual(dataPesquisa)) {
                System.out.println("achou");
                amount.add(calculaTempo(marcacao.getHoraInicio(), marcacao.getHoraFim()));
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
        marcacoes.forEach(marcacao -> {
            String s = marcacao.getHoraFim() == null ? null : marcacao.getHoraFim().format(dateTimeFormatter);
            System.out.println(marcacao.getDescricao() + " " + marcacao.getHoraInicio().format(dateTimeFormatter) + " " + s);
        });
    }

    public List<Marcacao> getMarcacoes() {
        return marcacoes;
    }

    public void setMarcacoes(List<Marcacao> marcacoes) {
        this.marcacoes = marcacoes;
    }

    public boolean isContando() {
        return contando;
    }
}
