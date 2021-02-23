package payroll;

import java.text.DecimalFormat;

/**
 * This class extends the Employee class and includes specific data and operations for a part-time employee.
 *
 * @author Sailokesh Mondi, Tanay Somisetty
 */

public class Parttime extends Employee {
    private int hoursWorked;
    final static int Max_Hours = 80;

    /**
     The default constructor that sets the Profile instance variable to null.
     @param 'none'
     */
    public Parttime() {
        this(null, 0);
    }

    /**
     Constructor that takes profile and compensation. Calls the constructor from the super class.
     * @param profile of employee
     * @param comp of employee
     */
    public Parttime(Profile profile, double comp) {
        super(profile, comp);
    }

    /**
     *
     */
    @Override
    public void calculatePayment() {
        int regHours = this.hoursWorked;
        int overTimeHours = 0;

        if (regHours > 80) {
            overTimeHours = regHours - 80;
            regHours = 80;
        }

        double regPay = regHours * super.getComp();
        double overTimePay = overTimeHours * (super.getComp() * 1.5);

        super.setPayment(regPay + overTimePay);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {

        DecimalFormat dFormat = new DecimalFormat("'$'0.00");

        String profileInfo = super.toString();
        String paymentInfo = String.valueOf(dFormat.format(super.getPayment()));
        String wageInfo = String.valueOf(dFormat.format(super.getComp()));
        String hoursInfo = String.valueOf(this.hoursWorked);

        return (profileInfo + "::" + "Payment " + paymentInfo + "::PART TIME::Houry Rate " + wageInfo + "::Hours " +
                "worked this period: " + hoursInfo);

    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Parttime) {
            Parttime parttime = (Parttime) obj;
            Profile inProfile = parttime.getProfile();

            Boolean nameCheck = inProfile.getName().equals(getProfile().getName());
            Boolean deptCheck = inProfile.getDepartment().equals(getProfile().getDepartment());
            int dateCheck = inProfile.getDateHired().compareTo(getProfile().getDateHired());

            if (nameCheck && deptCheck && (dateCheck == 0)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Accessor method to get the hours worked
     *
     * @param 'none'
     * @return an integer value that gets the hours worked for the employee
     */
    public int getHoursWorked() {
        return this.hoursWorked;

    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

}
