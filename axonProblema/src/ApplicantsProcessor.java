import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ApplicantsProcessor {

    public String processApplicants(InputStream csvStream) {
        List<Applicant> applicants = readApplicantsFromCSV(csvStream);
        if (applicants.isEmpty()) {
            return "{\"error\": \"No valid applicants found\"}";
        }

        List<TopApplication> topApplications = adjustScores(applicants);
        int uniqueApplicantsCount = countUniqueApplicants(applicants);
        List<String> topApplicantLastNames = getTopApplicantLastNames(topApplications);
        double averageTopHalfScore = calculateAverageTopHalfScore(topApplications);

        return String.format("{\"uniqueApplicants\": %d, \"topApplicants\": %s, \"averageScore\": %.2f}",
                uniqueApplicantsCount, topApplicantLastNames, averageTopHalfScore);
    }

    private List<Applicant> readApplicantsFromCSV(InputStream csvStream) {
        List<Applicant> applicants = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(csvStream))) {
            String line;
            boolean skipHeader = true;
            while ((line = reader.readLine()) != null) {
                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }
                Applicant applicant = parseApplicantFromCSVLine(line);
                if (applicant != null) {
                    applicants.add(applicant);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return applicants;
    }

    private Applicant parseApplicantFromCSVLine(String line) {
        String[] parts = line.split(",");
        if (parts.length == 4) {
            try {
                String name = parts[0].trim();
                String[] nameParts = name.split("\\s+");
                String firstName = nameParts[0];
                String lastName = nameParts[nameParts.length - 1];
                String email = parts[1].trim();
                double score = Double.parseDouble(parts[3].trim());
                LocalDateTime deliveryDateTime = LocalDateTime.parse(parts[2].trim());
                return new Applicant(firstName, lastName, email, deliveryDateTime, score);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private List<TopApplication> adjustScores(List<Applicant> applicants) {
        return applicants.stream()
                .map(applicant -> new TopApplication(applicant.getFirstName(), applicant.getLastName(), applicant.getEmail(),
                        applicant.getDeliveryDateTime(), applicant.getScore()))
                .sorted((a1, a2) -> Double.compare(a2.getScore(), a1.getScore()))
                .collect(Collectors.toList());
    }

    private int countUniqueApplicants(List<Applicant> applicants) {
        return (int) applicants.stream().map(Applicant::getEmail).distinct().count();
    }

    private List<String> getTopApplicantLastNames(List<TopApplication> topApplications) {
        return topApplications.stream()
                .limit(3)
                .map(Applicant::getLastName)
                .collect(Collectors.toList());
    }

    private double calculateAverageTopHalfScore(List<TopApplication> topApplications) {
        List<TopApplication> sortedApplications = topApplications.stream()
                .sorted((a1, a2) -> Double.compare(a2.getScore(), a1.getScore()))
                .collect(Collectors.toList());

        int topHalfSize = sortedApplications.size() / 2;
        if (topHalfSize == 0) {
            return 0;
        }

        double sum = sortedApplications.stream().limit(topHalfSize).mapToDouble(Applicant::getScore).sum();
        return sum / topHalfSize;
    }
}
