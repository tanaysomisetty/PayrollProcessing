package payroll;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


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
    public void setUp() {
        company = new Company();
        Date d1 = new Date("7/1/2020");
        Profile p1 = new Profile("Doe,Jane", "CS", d1);
        Parttime e1 = new Parttime(p1, 0);
        company.add(e1);

    }

    /**
     Test case to test add for true. Add method should
     add employee since the employee does not exist in list
     */
    @Test
    public void testAddForTrue() {

        Date d1 = new Date("7/1/2020");
        Profile p1 = new Profile("Sam,Jane", "ECE", d1);
        Employee e1 = new Parttime(p1, 0);
        boolean firstTime = company.add(e1);
        Assert.assertTrue(firstTime);

    }

    /**
     Test case to test for false. Add method should not
     add employee since the employee exists in list
     */
    @Test
    public void testAddForFalse() {
        Date d1 = new Date("7/1/2020");
        Profile p1 = new Profile("Doe,Jane", "CS", d1);
        Employee e1 = new Parttime(p1, 0);

        boolean secondTime = company.add(e1);
        Assert.assertFalse(secondTime);

    }

    /**
     Test case to test for grow. Add method will call grow if
     the employee list array exceeds initial capacity. Grow method
     will automatically grow capacity of array by 4.
     */
    @Test
    public void testAddAfterGrow() {
        Date d = new Date("7/1/2020");
        Profile p1 = new Profile("Doe,Jane1", "CS", d);
        Employee e1 = new Parttime(p1, 0);

        Profile p2 = new Profile("Doe,Jane2", "CS", d);
        Employee e2 = new Parttime(p2, 0);

        Profile p3 = new Profile("Doe,Jane3", "CS", d);
        Employee e3 = new Parttime(p3, 0);

        company.add(e1);
        company.add(e2);
        company.add(e3);

        Profile p4 = new Profile("Doe,Jane4", "CS", d);
        Employee e4 = new Parttime(p4, 0);

        boolean added = company.add(e4);

        Assert.assertTrue(added);

    }

    /**
     Test case to test remove for true. Remove method should remove the
     respective employee from list since employee is already added.
     */
    @Test
    public void testRemoveTrue() {
        Date d1 = new Date("7/1/2020");
        Profile p1 = new Profile("Doe,Jane", "CS", d1);
        Employee e1 = new Parttime(p1, 0);
        boolean removed = company.remove(e1);
        Assert.assertTrue(removed);
    }

    /**
     Test case to test remove for false. Remove method should not work since
     respective employee has not been added to list.
     */
    @Test
    public void testRemoveFalse() {
        Date d1 = new Date("7/1/2020");
        Profile p1 = new Profile("Fake,Jane", "CS", d1);
        Employee e1 = new Parttime(p1, 0);
        boolean removed = company.remove(e1);
        Assert.assertFalse(removed);
    }

    /**
     Test case to test setHours for true. setHours method should set the specified hours
     for a part-time employee.
     */
    @Test
    public void testSetHoursTrue() {
        Date d1 = new Date("7/1/2020");
        Profile p1 = new Profile("Doe1, Jane", "CS", d1);
        Parttime e1 = new Parttime(p1, 0);
        e1.setHoursWorked(10);
        company.add(e1);
        boolean setHours = company.setHours(e1);
        Assert.assertTrue(setHours);
    }

    /**
     Test case to test setHours for false negative value. setHours method should not set
     the specified hours since hours are negative.
     */
    @Test
    public void testSetHoursWhenNegativeHoursFalse() {
        Date d1 = new Date("7/1/2020");
        Profile p1 = new Profile("Doe2, Jane", "CS", d1);
        Parttime e1 = new Parttime(p1, 0);
        e1.setHoursWorked(-1);
        company.add(e1);
        boolean setHours = company.setHours(e1);
        Assert.assertFalse(setHours);
    }

    /**
     * Test case to test setHours for false value greater than 100. SetHours method
     * should not set the specified hours since hours are greater than 100.
     */
    @Test
    public void testSetHoursWhenGreaterThan100False() {
        Date d1 = new Date("7/1/2020");
        Profile p1 = new Profile("Doe3, Jane", "CS", d1);
        Parttime e1 = new Parttime(p1, 0);
        e1.setHoursWorked(101);
        company.add(e1);
        boolean setHours = company.setHours(e1);
        Assert.assertFalse(setHours);
    }
}