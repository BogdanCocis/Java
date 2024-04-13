import java.time.LocalDateTime;

public class Email extends Name {
    public Email(String name, String lastName, String email, LocalDateTime deliveryDateTime, double score) {
        super(name, lastName, email, deliveryDateTime, score);
    }

    public Email(String name, String lastName, String email, LocalDateTime deliveryDateTime, double score, int counterArond) {
        super(name, lastName, email, deliveryDateTime, score);
    }

    public boolean isValidEmail(String email) {
        if (email == null || email.isEmpty())
            return false;
        int atIndex = email.indexOf('@');
        int dotIndex = email.lastIndexOf('.');
        if (atIndex == -1 || email.indexOf('@', atIndex + 1) != -1)
            return false;
        if (dotIndex == -1 || dotIndex <= atIndex + 1 || dotIndex == email.length() - 1)
            return false;
        char firstChar = email.charAt(0);
        char lastChar = email.charAt(email.length() - 1);
        if (!Character.isLetterOrDigit(firstChar) || !Character.isLetterOrDigit(lastChar))
            return false;
        for (int i = 0; i < email.length(); ++i) {
            char currentChar = email.charAt(i);
            if (!Character.isLetterOrDigit(currentChar) && currentChar != '@' && currentChar != '.' && currentChar != '-' && currentChar != '_')
                return false;
        }
        return true;
    }
}
