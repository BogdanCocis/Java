import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class UniqueApplication extends Score {
    private static Map<String, UniqueApplication> uniqueApplicantsMap = new HashMap<>();

    public UniqueApplication(String name, String lastName, String email, LocalDateTime deliveryDateTime, double score) {
        super(name, lastName, email, deliveryDateTime, score);
        uniqueApplicantsMap.put(email, this);
    }

    public static int getUniqueApplicantsCount() {
        return uniqueApplicantsMap.size();
    }
}
