/**
 Extends the Full-time class and includes specific data and operations to a full-time employee with a management role.
 @author Sailokesh Mondi, Tanay Somisetty
 */

public class Management extends Fulltime{
    private int managerCode;
    private double extraComp;

    public Management() {
        this(null, 0, 0);

    }

    public Management(Profile profile, double comp, int managerCode){
        super(profile, comp);
        final double MANAGER_COMP = 5000;
        final double DEPT_HEAD_COMP = 9500;
        final double DIRECTOR_COMP = 12000;
        final int PAYMENT_PERIODS = 26;

        if (managerCode == 1) { //Manager
            this.managerCode = managerCode;
            this.extraComp = MANAGER_COMP / PAYMENT_PERIODS;
        }
        else if (managerCode == 2 ) { //Department Head
            this.managerCode = managerCode;
            this.extraComp = DEPT_HEAD_COMP / PAYMENT_PERIODS;
        }
        else if (managerCode == 3) { //Director
            this.managerCode = managerCode;
            this.extraComp = DIRECTOR_COMP / PAYMENT_PERIODS;
        }
    }


    @Override
    public void calculatePayment() {
        super.calculatePayment();

        super.setPayment(super.getPayment() + this.extraComp);

    }

    @Override
    public String toString(){
        String fulltimeInfo = super.toString();
        String extraCompInfo = String.valueOf(this.extraComp);

        return (fulltimeInfo + "::Manager Compensation $" + extraCompInfo);
    }

    @Override
    public boolean equals(Object obj){
        return super.equals(obj);
    }

}
