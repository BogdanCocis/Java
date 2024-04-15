import java.time.LocalDateTime;

public class Name extends Applicant {
    public Name(String name, String lastName, String email, LocalDateTime deliveryDateTime, double score) {
        super(name, lastName, email, deliveryDateTime, score);
    }

    public boolean isValidName(String name) {
        if (name == null || name.isEmpty()) {
            return false;
        }
        char firstChar = name.charAt(0);
        if ((firstChar >= 'a' && firstChar <= 'z') || (firstChar >= 'A' && firstChar <= 'Z')) {
            return true;
        } else {
            return false;
        }
    }
}
