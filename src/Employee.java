/**
 Defines the common data and operations for all employee types.
 @author Sailokesh Mondi, Tanay Somisetty
 */

public abstract class Employee {
    private Profile profile;

    public Employee(){
        this.profile = null;
    }

    public Employee(Profile profile){
        this.profile = profile;
    }

    public abstract void calculatePayment();

    @Override
    public String toString() {
        return super.toString();
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
    protected Profile getProfile(){
        return this.profile;
    }

    /**
     Modifier method that sets the Profile instance variable for this class.
     @param 'New' Profile object wish to be set
     */
    protected void setProfile(Profile profile){
        this.profile = profile;
    }
}
