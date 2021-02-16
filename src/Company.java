/**
 An array-based container class that implements employee database.
 Stores a list of employees, which may include instances of full-time,part-time,
 and management.
 @author Sailokesh Mondi, Tanay Somisetty
 */

public class Company {
    private Employee[] emplist;
    private int numEmployee;
    final static int INITIAL_CAPACITY = 4;

    public Company() {
        this.emplist = new Employee[INITIAL_CAPACITY];
        numEmployee = 0;
    }

    private int find(Employee employee) {
        int number = Integer.valueOf(employee.);
        for (int i = 0; i < this.emplist.length && emplist[i]!=null; i++) {
            Employee currentEmployee =
        }

    }

    private void grow() {

        int currCapacity = this.emplist.length;
        Employee[] newEmployees = new Employee[currCapacity+=4];

        for (int i = 0; i < currCapacity; i++) {
            Employee currentEmployee = this.emplist[i];
            Employee newEmployee =

                }
            }









    /**
     * Method to check the profile before adding.
     * @param employee
     * @return
     */
    public boolean add(Employee employee) {


    }

    /**
     * Method to maintain the original sequence.
     * @param employee
     * @return
     */
    public boolean remove(Employee employee) {


    }

    /**
     * Method to set working hours for a part-time employee.
     * @param employee
     * @return
     */
    public boolean setHours(Employee employee) {

    }

    /**
     * Method to process payments for all employees.
     * @param 'none'
     */
    public void processPayments() {

    }

    /**
     * Method to print earning statements for all employees.
     * @param 'none'
     */
    public void print() {

    }

    /**
     * Method to print earning statements by department.
     * @param 'none'
     */
    public void printByDepartment() {

    }

    /**
     * Method to print earning statements by date hired.
     * @param 'none'
     */
    public void printByDate() {

    }

}





