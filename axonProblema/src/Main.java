import java.io.FileInputStream;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) {
        String csvFilePath = "/Users/bogdancocis/Documents/Propriu/axonProblema/tabelCandidati.csv";

        processCSV(csvFilePath);
    }

    private static void processCSV(String csvFilePath) {
        try {
            InputStream inputStream = new FileInputStream(csvFilePath);
            ApplicantsProcessor processor = new ApplicantsProcessor();
            String result = processor.processApplicants(inputStream);
            System.out.println("Processing result:");
            System.out.println(result);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
