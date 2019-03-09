package domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.StringJoiner;

public class Mark {

    private LocalDateTime startDateTime;
    private String description;
    private LocalDateTime endDateTime;
    private DateTimeFormatter dateTimeFormatterPattern = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public Mark(String description, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.startDateTime = startDateTime;
        this.description = description;
        this.endDateTime = endDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringJoiner stringBuilder = new StringJoiner(" ");
        stringBuilder.add(description);
        stringBuilder.add(startDateTime.format(dateTimeFormatterPattern));
        if (endDateTime != null)
            stringBuilder.add(endDateTime.format(dateTimeFormatterPattern));
        return stringBuilder.toString();
    }
}
