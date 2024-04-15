import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Score extends DeliverDateTime{
    public Score(String name, String lastName, String email, LocalDateTime deliveryDateTime, double score) {
        super(name, lastName, email, deliveryDateTime, score);
    }
    public boolean isValidScoreFormat(double score) {
        if (score < 0 || score > 10)
            return false;
        String scoreStr = String.valueOf(score);
        String regex = "\\d+(\\.\\d{1,2})?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(scoreStr);
        return matcher.matches();
    }
}
