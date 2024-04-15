import java.time.LocalDateTime;

public class Applicant {
    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime deliveryDateTime;
    private double score;

    public Applicant(String firstName, String lastName, String email, LocalDateTime deliveryDateTime, double score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.deliveryDateTime = deliveryDateTime;
        this.score = score;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDeliveryDateTime() {
        return deliveryDateTime;
    }

    public void setDeliveryDateTime(LocalDateTime deliveryDateTime) {
        this.deliveryDateTime = deliveryDateTime;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
