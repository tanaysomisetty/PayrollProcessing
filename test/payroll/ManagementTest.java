package payroll;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.DecimalFormat;

import static org.junit.Assert.*;

public class ManagementTest {

    private static final double MANAGER_BONUS = 5000/26;
    private static final double DEP_HEAD_BONUS = 9500/26;
    private static final double DIRECTOR_BONUS = 12000/26;


    /**
     Test case to test calculate method for a Department Head role. Method should
     get the total compensation for Department Head.
     */
    @Test
    public void testCalculatePaymentForManager() {


        Date d1 = new Date("7/20/2020");
        Profile p1 = new Profile("Doe, Jane", "CS", d1);
        Management management = new Management(p1, 100000, 1);

        management.calculatePayment();
        double payment = management.getPayment();
        Assert.assertEquals((MANAGER_BONUS+100000/26), payment, 0.6);
    }

    /**
     Test case to test calculate method for a Department Head role. Method should
     get the total compensation for Department Head.
     */
    @Test
    public void testCalculatePaymentForDeptHead() {
        Date d1 = new Date("7/20/2020");
        Profile p1 = new Profile("Doe, Jane", "CS", d1);
        Management management = new Management(p1, 150000, 2);

        management.calculatePayment();
        double payment = management.getPayment();
        Assert.assertEquals((DEP_HEAD_BONUS+150000/26), payment, 1.0);
    }

    /**
     Test case to test calculate method for a Director role. Method should
     get the total compensation for Director.
     */
    @Test
    public void testCalculatePaymentForDirector() {
        Date d1 = new Date("7/20/2020");
        Profile p1 = new Profile("Doe, Jane", "CS", d1);
        Management management = new Management(p1, 170000, 3);

        management.calculatePayment();
        double payment = management.getPayment();
        Assert.assertEquals((DIRECTOR_BONUS+170000/26), payment, 1.0);
    }



}