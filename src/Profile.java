/**
 Defines the profile of an employee with variables.
 @author Sailokesh Mondi, Tanay Somisetty
 */

public class Profile {
    private String name; //employee's name in the form "lastname,firstname"
    private String department; //department code: CS, ECE, IT
    private Date dateHired;


    /**
     Gives a string representation for a Profile object.
     @param 'none'
     @return a string in the format of "lastname,firtname::DEPT::MM/DD/YYYY
     */
    @Override
    public String toString() {
        return this.name + "::" + department + "::" + this.dateHired.getDate();
    }


    /**
     Compares a Profile object with another Profile object so see if they're equal.
     Compares name, department, and dateHired.
     @param obj
     @return true if obj is a Profile object and is equal to this class's instance variables, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Profile) {
            Profile profile = (Profile) obj;
            if ((this.name.equals(profile.name) && this.department.equals(profile.department) &&
                    this.dateHired.equals(profile.dateHired))){
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
}
