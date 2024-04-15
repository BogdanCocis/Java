import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class AvrageApplication extends UniqueApplication {
    public AvrageApplication(String name, String lastName, String email, LocalDateTime deliveryDateTime, double score) {
        super(name, lastName, email, deliveryDateTime, score);
    }

    public static double calculateAverageScore(List<AvrageApplication> applications) {
        List<AvrageApplication> sortedApplications = applications.stream()
                .sorted((a1, a2) -> Double.compare(a2.getScore(), a1.getScore()))
                .collect(Collectors.toList());

        int totalApplications = sortedApplications.size();

        if (totalApplications == 0 || totalApplications == 1)
            return 0;

        int topHalfSize = totalApplications / 2;

        double sum = 0;
        for (int i = 0; i < topHalfSize; i++) {
            sum += sortedApplications.get(i).getScore();
        }

        double averageScore = sum / topHalfSize;

        return Math.round(averageScore * 100.0) / 100.0;
    }
}
