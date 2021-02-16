/**
 Defines the common data and operations for all employee types.
 @author Sailokesh Mondi, Tanay Somisetty
 */

public abstract class Employee {
    private Profile profile;



    public abstract void calculatePayment();

    @Override
    public String toString() {
        return super.toString();
    }
}
