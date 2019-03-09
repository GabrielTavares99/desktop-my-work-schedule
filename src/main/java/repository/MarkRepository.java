package repository;

import domain.Mark;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class MarkRepository {

    private static Mark[] marks = {
            new Mark("Mark 1", LocalDateTime.of(2019, Month.MARCH, 5, 9, 0), LocalDateTime.of(2019, Month.MARCH, 5, 12, 0)),
            new Mark("Mark 2", LocalDateTime.of(2019, Month.MARCH, 5, 13, 0), LocalDateTime.of(2019, Month.MARCH, 5, 17, 29)),
    };

    public List<Mark> todas() {
        return Arrays.asList(marks);
    }

}
