package repository;

import myworktime.domain.Marcacao;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class MarcacaoRepository {

    private static Marcacao[] marcacaos = {
            new Marcacao("Marcacao 1", LocalDateTime.of(2019, Month.MARCH, 5, 9, 0), LocalDateTime.of(2019, Month.MARCH, 5, 12, 0)),
            new Marcacao("Marcacao 2", LocalDateTime.of(2019, Month.MARCH, 5, 13, 0), LocalDateTime.of(2019, Month.MARCH, 5, 17, 29)),
    };

    public List<Marcacao> todas() {
        return Arrays.asList(marcacaos);
    }

}
