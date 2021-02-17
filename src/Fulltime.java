/**
 Extends the Employee class and includes specific data and operations to a full-time employee
 @author Sailokesh Mondi, Tanay Somisetty
 */

public class Fulltime extends Employee{


    public Fulltime(){
        this(null, 0);
    }

    public Fulltime(Profile profile, double comp){
        super(profile, comp);
    }


    @Override
    public void calculatePayment() {

    }

    @Override
    public String toString(){

        String profileInfo = super.toString();
        String payment = String.valueOf(super.getPayment());
        String salary = String.valueOf(super.getComp());

        return (profileInfo + "::" + "Payment $" + payment + "::FULL TIME::Annual Salary $" + salary);

    }

    @Override
    public boolean equals(Object obj){
        return super.equals(obj);
    }
}
