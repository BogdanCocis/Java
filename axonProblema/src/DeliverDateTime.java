import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeliverDateTime extends Email {
    public DeliverDateTime(String name, String lastName, String email, LocalDateTime deliveryDateTime, double score) {
        super(name, lastName, email, deliveryDateTime, score);
    }

    public boolean isValidDateTimeFormat(String dateTime) {
        if (dateTime == null || dateTime.isEmpty())
            return false;
        String regex = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dateTime);
        return matcher.matches();
    }
}
