package payroll;
/**
 * The user interface class that reads/writes from/to the console.
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


        /*WORKING HOURS: Make sure hours do not exceed 100 hours per pay period
         */

        System.out.println("Payroll Processing starts.");

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        myCompany = new Company();

        while (input != "Q") {
            String[] tokens = input.split("\\s+");

            final int COMMAND_INDEX = 0;
            final int NAME_INDEX = 1;
            final int DEPARTMENT_INDEX = 2;
            final int DATE_INDEX = 3;
            final int COMPENSATION_INDEX = 4;
            final int MANAGER_ROLE_INDEX = 5;

            String nextCmd = tokens[COMMAND_INDEX];

            try {
                nextCmd = testInput(nextCmd, "command");
            }
            catch (InputMismatchException e) {
                System.out.println("Command '" + nextCmd + "' not supported!");
            }

            if (nextCmd.equals("AP") || nextCmd.equals("AF") || nextCmd.equals("AM")) {
                try {
                    String newName = testInput(tokens[NAME_INDEX], "name");
                    String newDept = testInput(tokens[DEPARTMENT_INDEX], "department");
                    String newDateHired = testInput(tokens[DATE_INDEX], "date");
                    double newComp = Double.valueOf(testInput(tokens[COMPENSATION_INDEX], "comp"));
                    Date newDate = new Date(newDateHired);
                    Profile newProfile = new Profile(newName, newDept, newDate);
                    if (nextCmd.equals("AP")) {
                        Parttime newPT = new Parttime(newProfile, newComp);
                        boolean added = myCompany.add(newPT);
                        if (added) {
                            System.out.println("Employee added.");
                        }
                        else {
                            System.out.println("Employee is already in the list");
                        }
                    }
                    else if (nextCmd.equals("AF")) {
                        Fulltime newFT = new Fulltime(newProfile, newComp);
                        boolean added = myCompany.add(newFT);
                        if (added) {
                            System.out.println("Employee added.");
                        }
                        else {
                            System.out.println("Employee is already in the list");
                        }
                    }
                    else if (nextCmd.equals("AM")) {
                        int newMangRole = Integer.valueOf(testInput(tokens[MANAGER_ROLE_INDEX], "manager_role"));
                        Management newMG = new Management(newProfile, newComp, newMangRole);
                        boolean added = myCompany.add(newMG);
                        if (added) {
                            System.out.println("Employee added.");
                        }
                        else {
                            System.out.println("Employee is already in the list");
                        }
                    }
                }
                catch (InputMismatchException e){
                    if (e.getMessage().equals("department error")) {
                        System.out.println("'" + tokens[DEPARTMENT_INDEX] + "' is not a valid department code.");
                    }
                    else if (e.getMessage().equals("date error")) {
                        System.out.println(tokens[DATE_INDEX] + " is not a valid date!");
                    }
                    else if (e.getMessage().equals("compensation error")) {
                        System.out.println("Salary cannot be negative");
                    }
                    else if (e.getMessage().equals("manager-role error")) {
                        System.out.println("Invalid management code");
                    }
                }
            }

            else if (nextCmd.equals("R")){
                try {
                    String newName = testInput(tokens[NAME_INDEX], "name");
                    String newDept = testInput(tokens[DEPARTMENT_INDEX], "department");
                    String newDateHired = testInput(tokens[DATE_INDEX], "date");

                    Date newDate = new Date(newDateHired);
                    Profile newProfile = new Profile(newName, newDept, newDate);
                    Employee newEM = new Employee(newProfile, 0);
                    System.out.println(newEM.toString()); //DELETE;

                    int numEmployee = myCompany.getNumEmployee();
                    if (numEmployee == 0) {
                        System.out.println("Employee database is empty");
                    }
                    else {
                        boolean removed = myCompany.remove(newEM);
                        if (removed) {
                            System.out.println("Employee removed.");
                        }
                        else {
                            System.out.println("Employee does not exist");
                        }
                    }
                }
                catch (InputMismatchException e){
                    if (e.getMessage().equals("department error")) {
                        System.out.println("'" + tokens[DEPARTMENT_INDEX] + "' is not a valid department code.");
                    }
                    else if (e.getMessage().equals("date error")) {
                        System.out.println(tokens[DATE_INDEX] + " is not a valid date!");
                    }
                }
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

    private String testInput(String input, String option) {


        if (option.equals("command")) {
            String cmdOptions = "AP AF AM R C S PA PH PD Q";
            if (!cmdOptions.contains(input)){
                throw new InputMismatchException("command error");

            }
            return input;
        }

        else if (option.equals("name")) {
            return input;
        }

        else if (option.equals("department")) {
            String deptOptions = "CS ECE IT";
            if (!deptOptions.contains(input)){
                throw new InputMismatchException("department error");
            }
            return input;

        }

        else if (option.equals("date")) {
            Date testDate = new Date(input);
            if (!testDate.isValid()){
                throw new InputMismatchException("date error");
            }
            return input;

        }

        else if (option.equals("comp")) {
            double doubleComp = Double.valueOf(input);
            if (doubleComp < 0) {
                throw new InputMismatchException("compensation error");
            }
            return input;
        }

        else if (option.equals("manager_role")) {
            String mangOptions = "1 2 3";
            if (!mangOptions.contains(input)) {
                throw new InputMismatchException("manager-role error");
            }

            return input;
        }

        return input;
    }

}
