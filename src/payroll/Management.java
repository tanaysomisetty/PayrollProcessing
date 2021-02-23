package payroll;

import java.text.DecimalFormat;

/**
 * Extends the Full-time class and includes specific data and operations to a full-time employee with a management role.
 *
 * @author Sailokesh Mondi, Tanay Somisetty
 */

public class Management extends Fulltime{
    private int managerCode;
    private double extraComp;

    /**
     * The default constructor
     */
    public Management() {
        this(null, 0, 0);

    }

    /**
     *
     * @param profile
     * @param comp
     * @param managerCode
     */
    public Management(Profile profile, double comp, int managerCode) {
        super(profile, comp);
        final double MANAGER_COMP = 5000;
        final double DEPT_HEAD_COMP = 9500;
        final double DIRECTOR_COMP = 12000;
        final int PAYMENT_PERIODS = 26;

        if (managerCode == 1) { //Manager
            this.managerCode = managerCode;
            this.extraComp = MANAGER_COMP / PAYMENT_PERIODS;
        } else if (managerCode == 2) { //Department Head
            this.managerCode = managerCode;
            this.extraComp = DEPT_HEAD_COMP / PAYMENT_PERIODS;
        } else if (managerCode == 3) { //Director
            this.managerCode = managerCode;
            this.extraComp = DIRECTOR_COMP / PAYMENT_PERIODS;
        }
    }

    /**
     Method to calculate payments for a management employee
     @param 'none'
     */
    @Override
    public void calculatePayment() {
        super.calculatePayment();

        super.setPayment(super.getPayment() + this.extraComp);

    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {


        String fulltimeInfo = super.toString();
        DecimalFormat dFormat = new DecimalFormat("'$'0.00");
        String extraCompInfo = String.valueOf(dFormat.format(this.extraComp));

        if (managerCode == 1) { //Manager
            return (fulltimeInfo + "::Manager Compensation " + extraCompInfo);
        } else if (managerCode == 2) { //Department Head
            return (fulltimeInfo + "::DepartmentHead Compensation " + extraCompInfo);
        } else if (managerCode == 3) { //Director
            return (fulltimeInfo + "::Director Compensation " + extraCompInfo);
        }

        return (fulltimeInfo + "::Manager Compensation " + extraCompInfo);
    }

    /**
     Method that
     @param obj
     @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Management) {
            Management management = (Management) obj;
            Profile inProfile = management.getProfile();

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

    }

