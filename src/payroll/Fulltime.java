package payroll;

/**
 * Extends the Employee class and includes specific data and operations to a full-time employee
 *
 * @author Sailokesh Mondi, Tanay Somisetty
 */

public class Fulltime extends Employee {


    public Fulltime() {
        this(null, 0);
    }

    public Fulltime(Profile profile, double comp) {
        super(profile, comp);
    }


    @Override
    public void calculatePayment() {
        final int PAYMENT_PERIODS = 26;
        double annualSalary = super.getComp();

        super.setPayment(annualSalary / PAYMENT_PERIODS);
    }

    @Override
    public String toString() {

        String profileInfo = super.toString();
        String paymentInfo = String.valueOf(super.getPayment());
        String salaryInfo = String.valueOf(super.getComp());

        return (profileInfo + "::" + "Payment $" + paymentInfo + "::FULL TIME::Annual Salary $" + salaryInfo);

    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
