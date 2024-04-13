import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

public class ApplicantsProcessorTest {

    @Test
    public void testProcessApplicants() {
        String csvData = "Speranța Cruce,speranta_cruce@gmail.com,2023-01-24T20:14:53,2.33\n"
                + "Ionică Sergiu Ramos,chiarel@ionicaromass.ro,2023-01-24T16:32:19,9.00\n"
                + "Carla Ștefănescu,carlita_ste@yahoo.com,2023-01-23T23:59:01,5.20\n"
                + "Lucrețiu Hambare,hambare_lucretiu@outlook.com,2023-01-24T22:30:15,10\n"
                + "Robin Hoffman-Rus,robman@dasmail.de,2023-01-23T12:00:46,8.99\n";
        InputStream inputStream = new ByteArrayInputStream(csvData.getBytes());

        ApplicantsProcessor processor = new ApplicantsProcessor();
        String result = processor.processApplicants(inputStream);

        System.out.println("Processing result:" + result);

        assertNotNull(result);

        assertEquals(true, result.contains("\"uniqueApplicants\":"));
        assertEquals(true, result.contains("\"topApplicants\":"));
        assertEquals(true, result.contains("\"averageScore\":"));
    }
}
