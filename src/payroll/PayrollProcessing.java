package payroll;
/**
 * The user interface class that reads/writes form/to the console.
 * Handles all exceptions and invalid data before it calls the methods in Company class
 * to complete the associated commands.
 *
 * @author Sailokesh Mondi, Tanay Somisetty
 */

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class PayrollProcessing {
    private static Company myCompany = null;

    public void run() {


        /*
            For (S)ET WORKING HOURS: Make sure hours do not exceed 100 hours per pay period
         */

        System.out.println("Payroll Processing starts.");

        Scanner sc = new Scanner(System.in);

        String input = sc.next();



        myCompany = new Company();

        while (input != "Q") {
            StringTokenizer st = new StringTokenizer(input, " ");
            String commandType = "";
            try {
                commandType = st.nextToken();
            }
            catch (NoSuchElementException e) {
                //empty catch block
            }

            String nextCmd = "";

            try {
                nextCmd = testCmd(commandType);
            }
            catch (InputMismatchException e) {
                System.out.println("Command '" + commandType + "' not supported!");
            }

            if (nextCmd.equals("AP")) {
                System.out.println("Add partime");
            }

            else if (nextCmd.equals("AF")) {
                System.out.println("Add fulltime");
            }

            else if (nextCmd.equals("AM")) {
                System.out.println("Add manager");
            }

            else if (nextCmd.equals("R")){
                System.out.println("Remove employee");
            }

            else if (nextCmd.equals("S")){
                System.out.println("Set working hours");
            }

            else if (nextCmd.equals("C")) {
                myCompany.processPayments();
            }

            else if (nextCmd.equals("PA")) {
                    myCompany.print();
            }

            else if (nextCmd.equals("PH")) {
                myCompany.printByDate();
            }

            else if (nextCmd.equals("PD")) {
                myCompany.printByDepartment();
            }



            else if (nextCmd.equals("Q")){
                System.out.println("Payroll Processing completed.");
                System.exit(1);
            }

            input = sc.nextLine();
        }

    }

    private String testCmd(String cmd) {
        String cmdOptions = "AP AF AM R C S PA PH PD Q";

        if (!cmdOptions.contains(cmd)){
            throw new InputMismatchException("Command '" + cmd + "' not supported!");

        }
        return cmd;

    }


}
