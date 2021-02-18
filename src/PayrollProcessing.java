/**
 The user interface class that reads/writes form/to the console.
 Handles all exceptions and invalid data before it calls the methods in Company class
 to complete the associated commands.
 @author Sailokesh Mondi, Tanay Somisetty
 */

import java.util.Scanner;
import java.util.StringTokenizer;

public class PayrollProcessing {
    private static Company myCompany = null;

    public void run() {

        System.out.println("Payroll Processing starts.");

        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        String cmdOptions = "AP AF AM R C S PA PH PD Q";

        myCompany = new Company();

        while (input != "Q") {
            StringTokenizer st = new StringTokenizer(input, " ");
            String commandType = st.nextToken();
            if (!cmdOptions.contains(commandType)) {
                System.out.println("Command '" + commandType + "' not supported!");
            }
        }

    }


}
