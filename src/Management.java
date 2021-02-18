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
        if (managerCode == 1) { //Manager
            this.managerCode = managerCode;
            this.extraComp = 5000;
        }
        else if (managerCode == 2 ) { //Department Head
            this.managerCode = managerCode;
            this.extraComp = 9500;
        }
        else if (managerCode == 3) { //Director
            this.managerCode = managerCode;
            this.extraComp = 12000;
        }
    }


    @Override
    public void calculatePayment() {

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
