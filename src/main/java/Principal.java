import myworktime.domain.Marcacao;
import myworktime.repository.MarcacaoRepository;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Principal {

    public static void main(String[] args) {

        MarcacaoRepository marcacaoRepository = new MarcacaoRepository();
        List<Marcacao> todas = marcacaoRepository.todas();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        todas.forEach(marcacao -> {
            long between = ChronoUnit.MINUTES.between(marcacao.getHoraInicio(), marcacao.getHoraFim());
            System.out.println(between);
            System.out.printf("%-30s %s %s\n", marcacao.getDescricao(), marcacao.getHoraInicio().format(dateTimeFormatter), marcacao.getHoraFim().format(dateTimeFormatter));


        Period between = Period.between(LocalDate.of(1999, Month.MARCH, 14), LocalDate.now());
        System.out.println(between.getYears());
        System.out.println((long)between.getDays()); // ESTRANHO
        System.out.println((long)between.getMonths());

        });
    }

}
