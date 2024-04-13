import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TopApplication extends AvrageApplication {
    public TopApplication(String name, String lastName, String email, LocalDateTime deliveryDateTime, double score) {
        super(name, lastName, email, deliveryDateTime, score);

        if (isDeliveredInFirstDay(deliveryDateTime))
            score += 1;

        else if (isDeliveredInSecondHalfOfLastDay(deliveryDateTime))
            score -= 1;

        setScore(score);
    }
    private boolean isDeliveredInFirstDay(LocalDateTime deliveryDateTime) {
        LocalDate deliveryDate = deliveryDateTime.toLocalDate();
        return deliveryDate.equals(deliveryDate.minusDays(1));
    }
    private boolean isDeliveredInSecondHalfOfLastDay(LocalDateTime deliveryDateTime) {
        LocalDate deliveryDate = deliveryDateTime.toLocalDate();
        LocalTime deliveryTime = deliveryDateTime.toLocalTime();
        return deliveryTime.isAfter(LocalTime.NOON) && deliveryDate.equals(deliveryDate.minusDays(1));
    }
}
