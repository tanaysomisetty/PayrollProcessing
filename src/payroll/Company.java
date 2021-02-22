package payroll;

/**
 * An array-based container class that implements employee database.
 * Stores a list of employees, which may include instances of full-time,part-time,
 * and management.
 *
 * @author Sailokesh Mondi, Tanay Somisetty
 */

import java.util.Calendar;
import java.util.*;

public class Company {
    private Employee[] emplist;
    private int numEmployee;
    final static int INITIAL_CAPACITY = 4;
    final static int SORT_BY_DATE = 1;
    final static String DEPARTMENT_CS = "CS";
    final static String DEPARTMENT_ECE = "ECE";
    final static String DEPARTMENT_IT = "IT";

    public Company() {
        this.emplist = new Employee[INITIAL_CAPACITY];
        numEmployee = 0;
    }

    private int find(Employee employee) {

        int found = -1;

        if (emplist != null) {
            for (final Employee currentEmployee : emplist) {
                if (employee.equals(currentEmployee)) {
                    found = 1;
                    break;
                }
            }
        }
        return found;
    }

    private void grow() {

        int currCapacity = this.emplist.length;
        Employee[] newEmployees = new Employee[currCapacity + 4];

        for (int i = 0; i < currCapacity; i++) {
            newEmployees[i] = emplist[i];
        }

        emplist = newEmployees;


    }


    /**
     * Method to check the profile before adding.
     *
     * @param employee
     * @return
     */
    public boolean add(Employee employee) {

        if (find(employee) < 0) {
            // If the array is fully occupied, call grow
            if (numEmployee == emplist.length) {
                grow();
            }
            emplist[numEmployee] = employee;
            numEmployee++;
            return true;
        }
        return false;
    }

    /**
     * Method to maintain the original sequence.
     *
     * @param employee
     * @return
     */
    public boolean remove(Employee employee) {
        int removeIndex = find(employee);
        if (removeIndex >= 0) {
            emplist[removeIndex] = null;
            shift(removeIndex + 1);
            return true;
        } else {
            return false;
        }

    }

    /**
     * Helper method to shift all items of an array begin at index start to the end of the array back by 1
     *
     * @param 'starting' index
     */
    private void shift(int start) {

        for (int i = start; i < emplist.length; i++) {
            emplist[i - 1] = emplist[i];
        }
        emplist[emplist.length - 1] = null;

    }


    /**
     * Method to set working hours for a part-time employee.
     *
     * @param employee
     * @return
     */
    public boolean setHours(Employee employee) {

        boolean isPartTime = false;


        if (employee instanceof Parttime) {
            isPartTime = true;
        }

        return isPartTime;
    }

    /**
     * Method to process payments for all employees.
     *
     * @param 'none'
     */
    public void processPayments() {

        for (Employee employee : emplist) {
            if (employee instanceof Parttime) {
                Parttime partimeEmployee = (Parttime) employee;
                partimeEmployee.calculatePayment();
            } else if (employee instanceof Fulltime) {
                Fulltime fulltime = (Fulltime) employee;
                fulltime.calculatePayment();
            } else if (employee instanceof Management) {
                Management management = (Management) employee;
                management.calculatePayment();
            }
        }

    }

    /**
     * Method to print earning statements for all employees.
     *
     * @param 'none'
     */
    public void print() {

        for (int i = 0; i < numEmployee; i++) {
            System.out.println(emplist[i].toString());
        }
    }

    /**
     * Helper method to implement selection sort for two different purposes: sort by date hired and sort by department
     *
     * @param 'sorting' type/method
     */
    private void selectionSort(final int sortBy) {
        if (sortBy == SORT_BY_DATE) {
            for (int i = 0; i < numEmployee - 1; i++) {
                for (int j = i + 1; j < numEmployee; j++) {
                    Date dt1 = emplist[i].getProfile().getDateHired();
                    Calendar cal1 = Calendar.getInstance();
                    cal1.set(Calendar.DATE, dt1.getDay());
                    cal1.set(Calendar.MONTH, dt1.getMonth());
                    cal1.set(Calendar.YEAR, dt1.getYear());

                    Date dt2 = emplist[j].getProfile().getDateHired();
                    Calendar cal2 = Calendar.getInstance();
                    cal2.set(Calendar.DATE, dt2.getDay());
                    cal2.set(Calendar.MONTH, dt2.getMonth());
                    cal2.set(Calendar.YEAR, dt2.getYear());

                    if (cal1.getTime().compareTo(cal2.getTime()) > 0) {
                        Employee temp_employee = emplist[i];
                        emplist[i] = emplist[j];
                        emplist[j] = temp_employee;
                    }
                }

            }
        }
    }

    /**
     * Method to print earning statements by department.
     *
     * @param 'none'
     */
    public void printByDepartment() {


        Employee[] cSDepArray = new Employee[emplist.length];
        Employee[] eCEDepArray = new Employee[emplist.length];
        Employee[] itDepArray = new Employee[emplist.length];

        int csDepCount = 0;
        int eceDepCount = 0;
        int itDepCount = 0;

        for (int i = 0; i < emplist.length; i++) {
            String department = emplist[i].getProfile().getDepartment();
            if (DEPARTMENT_CS.equals(department)) {
                cSDepArray[csDepCount] = emplist[i];
                csDepCount++;
            } else if (DEPARTMENT_ECE.equals(department)) {
                eCEDepArray[eceDepCount] = emplist[i];
                eceDepCount++;
            } else if (DEPARTMENT_IT.equals(department)) {
                itDepArray[itDepCount] = emplist[i];
                itDepCount++;
            }
        }

        for (int i = 0; i < csDepCount; i++) {
            System.out.println(cSDepArray[i].getProfile().getName());
        }

        for (int i = 0; i < eceDepCount; i++) {
            System.out.println(eCEDepArray[i].getProfile().getName());
        }

        for (int i = 0; i < itDepCount; i++) {
            System.out.println(itDepArray[i].getProfile().getName());
        }


    }

    /**
     * Method to print earning statements by date hired.
     *
     * @param 'none'
     */
    public void printByDate() {

        if (numEmployee == 0) {
            System.out.println("Employee database is empty.");
        } else {
            selectionSort(SORT_BY_DATE);
            System.out.println("--Printing earning statements by date hired--");
            for (int i = 0; i < numEmployee; i++) {
                System.out.println(emplist[i].toString());
            }
            System.out.println("**End of list");
        }
    }

}





