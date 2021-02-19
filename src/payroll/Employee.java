package Payroll;

/**
 Defines the common data and operations for all employee types.
 @author Sailokesh Mondi, Tanay Somisetty
 */

public abstract class Employee {
    private Profile profile;
    private double comp; //Compensation for an Employee, can be the hourly pay rate or annual salary
    private double payment; //Current payment for an Employee after calculation

    /**
     The default constructor that sets the Profile instance variable to null.
     @param 'none'
     */
    public Employee(){
        this(null, 0);
    }


    /**
     This is the constructor to take a Profile object and create an Employee object.
     @param 'Profile' object, and compensation of type double
     */
    public Employee(Profile profile, double comp){
        this.profile = profile;
        this.comp = comp;
    }

    /**
     An abstract method to calculate the payment of an Employee object.
     */
    public abstract void calculatePayment();


    /**
     Give a string representation of an Employee object.
     Call the toString method for the Profile instance variable.
     @param 'none'
     @return a string in the format of "lastname,firtname::DEPT::MM/DD/YYYY"
     */
    @Override
    public String toString() {
        return this.profile.toString();
    }

    /**
     Checks to see if two Employee objects are equal.
     Compares the attributes of the Profile instance variable
     @param 'Object' to be compared
     @return true if both objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Employee){
            Employee employee = (Employee) obj;
            Profile profile = employee.profile;

            Boolean nameCheck = this.profile.getName().equals(profile.getName());
            Boolean deptCheck = this.profile.getDepartment().equals(profile.getDepartment());
            int dateCheck = this.profile.getDateHired().compareTo(profile.getDateHired());

            if (nameCheck && deptCheck && (dateCheck == 0)){
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    /**
     Accessor method that gets the Profile instance variable for this class.
     @param 'none'
     @return A Profile object
     */
    public Profile getProfile(){
        return this.profile;
    }

    /**
     Modifier method that sets the Profile instance variable for this class.
     @param 'New' Profile object wish to be set
     */
    public void setProfile(Profile profile){
        this.profile = profile;
    }

    /**
     Accessor method that gets the compensation for an Employee object
     @param 'none'
     @return a double type value that is either the hourly wage or annual salary for an employee
     */
    public double getComp() {
        return this.comp;
    }

    /**
     Accessor method that sets the compensation for an Employee object
     @param 'a' double type value that is either the hourly wage or annual salary for an employee
     */
    public void setComp(Double comp) {
        this.comp = comp;
    }

    /**
     Accessor method that gets the payment for an Employee object
     @param 'none'
     @return a double type value that is the calculated payment for the employee
     */
    public double getPayment() {
        return this.payment;
    }

    /**
     Accessor method that sets the payment for an Employee object
     @param 'a' double type value that is the calculated payment for the employee
     */
    public void setPayment(Double payment) {
        this.payment = payment;
    }
}
