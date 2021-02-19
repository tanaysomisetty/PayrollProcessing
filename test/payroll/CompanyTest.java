package payroll;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;

public class CompanyTest {

    Company company;

    /**
     * AP Doe,Jane CS 7/1/2020 45.9 //add a part-time employee with the hourly pay rate
     * AF Doe,Jane CS 1/1/2005 85000 //add a full-time employee with the annual salary
     * AM Doe,Jane CS 2/28/2012 85000 1 //add a full-time with the role “Manager”
     * AM Doe,John CS 2/28/2012 85000 2 //add a full-time with the role “Department Head”
     * AM Doe,John ECE 2/28/2012 85000 3 //add
     */

    @Before
    public void setUp()  {
        company = new Company();
        Date d1 = new Date("7/1/2020");
        Profile p1 = new Profile("Doe,Jane","CS",d1);
        Employee e1 = new Parttime(p1, 0);
        company.add(e1);

    }

    @Test
    public void testAddForTrue() {

        Date d1 = new Date("7/1/2020");
        Profile p1 = new Profile("Sam,Jane","ECE",d1);
        Employee e1 = new Parttime(p1, 0);
        boolean firstTime = company.add(e1);
        Assert.assertTrue(firstTime);

    }

    @Test
    public void testAddForFalse() {
        Date d1 = new Date("7/1/2020");
        Profile p1 = new Profile("Doe,Jane","CS",d1);
        Employee e1 = new Parttime(p1, 0);

        boolean secondTime = company.add(e1);
        Assert.assertFalse(secondTime);

    }

    @Test
    public void testAddAfterGrow() {
        Date d = new Date("7/1/2020");
        Profile p1 = new Profile("Doe,Jane1","CS",d);
        Employee e1 = new Parttime(p1, 0);

        Profile p2 = new Profile("Doe,Jane2","CS",d);
        Employee e2 = new Parttime(p2, 0);

        Profile p3 = new Profile("Doe,Jane3","CS",d);
        Employee e3 = new Parttime(p3, 0);

        company.add(e1);
        company.add(e2);
        company.add(e3);

        Profile p4 = new Profile("Doe,Jane4","CS",d);
        Employee e4 = new Parttime(p4, 0);

        boolean added  = company.add(e4);

        Assert.assertTrue(added);

    }

    @Test
    public void testRemoveTrue() {
        Date d1 = new Date("7/1/2020");
        Profile p1 = new Profile("Doe,Jane","CS",d1);
        Employee e1 = new Parttime(p1, 0);
        boolean removed = company.remove(e1);
        Assert.assertTrue(removed);
    }

    @Test
    public void testRemoveFalse() {
        Date d1 = new Date("7/1/2020");
        Profile p1 = new Profile("Fake,Jane","CS",d1);
        Employee e1 = new Parttime(p1, 0);
        boolean removed = company.remove(e1);
        Assert.assertFalse(removed);
    }

    @Test
    public void testSetHoursTrue() {

    }
}