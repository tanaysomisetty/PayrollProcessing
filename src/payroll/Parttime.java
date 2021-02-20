package payroll;

/**
 * This class extends the Employee class and includes specific data and operations for a part-time employee.
 *
 * @author Sailokesh Mondi, Tanay Somisetty
 */
public class Parttime extends Employee {
    private int hoursWorked;
    final static int Max_Hours = 80;

    public Parttime() {
        this(null, 0);
    }

    public Parttime(Profile profile, double comp) {
        super(profile, comp);
    }


    @Override
    public void calculatePayment() {
        int regHours = this.hoursWorked;
        int overTimeHours = 0;

        if (regHours > 80) {
            overTimeHours = regHours - 80;
        }

        double regPay = regHours * super.getComp();
        double overTimePay = overTimeHours * (super.getComp() * 1.5);

        super.setPayment(regPay + overTimePay);
    }

    @Override
    public String toString() {

        String profileInfo = super.toString();
        String paymentInfo = String.valueOf(super.getPayment());
        String wageInfo = String.valueOf(super.getComp());
        String hoursInfo = String.valueOf(this.hoursWorked);

        return (profileInfo + "::" + "Payment $" + paymentInfo + "::PART TIME::Houry Rate $" + wageInfo + "::Hours " +
                "worked this period: " + hoursInfo);

    }

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
