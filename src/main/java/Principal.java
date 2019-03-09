import domain.Mark;
import repository.MarkRepository;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Principal {

    public static void main(String[] args) {

        MarkRepository markRepository = new MarkRepository();
        List<Mark> todas = markRepository.todas();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        todas.forEach(mark -> {
            long between = ChronoUnit.MINUTES.between(mark.getStartDateTime(), mark.getEndDateTime());
            System.out.println(between);
            System.out.printf("%-30s %s %s\n", mark.getDescription(), mark.getStartDateTime().format(dateTimeFormatter), mark.getEndDateTime().format(dateTimeFormatter));


//        Period between = Period.between(LocalDate.of(1999, Month.MARCH, 14), LocalDate.now());
//        System.out.println(between.getYears());
//        System.out.println((long)between.getDays()); // ESTRANHO
//        System.out.println((long)between.getMonths());

        });
    }

}
