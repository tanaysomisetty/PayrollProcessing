/**
 This class extends the Employee class and includes specific data and operations for a part-time employee.
 @author Sailokesh Mondi, Tanay Somisetty
 */
public class Parttime extends Employee{
    private int hoursWorked;

    @Override
    public void calculatePayment() {

    }

    @Override
    public String toString(){
        return super.toString();
    }

    @Override
    public boolean equals(Object obj){
        return super.equals(obj);
    }

    /**
     Accessor method to get the hours worked
     @param 'none'
     @return an integer value that gets the hours worked for the employee
     */
    public int getHoursWorked() {
        return this.hoursWorked;

    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

}
