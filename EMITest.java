package com.company;

import static org.junit.jupiter.api.Assertions.*;

class EMITest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        System.out.println("Started");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.out.println("Finished");
    }

    @org.junit.jupiter.api.Test
    void getLoanType() {
        Loan loan = new Loan();

        /* Test 1 */
        String s = "Home".toLowerCase();
        float expected = 10.5f;
        assertEquals(expected, loan.getInterest(s));

        /* Test 2 */
        s = "Car".toLowerCase();
        expected = 8.2f;
        assertEquals(expected, loan.getInterest(s));

        /* Test 3 */
        s = "Personal".toLowerCase();
        expected = 6.8f;
        assertEquals(expected, loan.getInterest(s));

        /* Test 4 */
        expected = -1.0f;
        assertEquals(expected, loan.getInterest("hi"));
    }

    @org.junit.jupiter.api.Test
    void setUpdatedInterest() {
        Loan loan = new Loan();

        /* Test 1*/
        String s = "Home".toLowerCase();
        float interest = 0.0f;
        assertEquals(0, loan.setUpdatedInterest(interest, s));

        /* Test 2*/
        s = "Car".toLowerCase();
        assertEquals(0, loan.setUpdatedInterest(interest, s));

        /* Test 3*/
        s = "Personal".toLowerCase();
        assertEquals(0, loan.setUpdatedInterest(interest, s));

        /* Test 4*/
        assertEquals(1, loan.setUpdatedInterest(interest, "hi"));
    }

    @org.junit.jupiter.api.Test
    void calculateEMI() {

        /* Test 1*/
        int principalAmount = 5000000;
        float interest = 10.5f;
        int tenure = 12;
        int expected = 440744;
        assertEquals(expected, Loan.calculateEMI(principalAmount, interest, tenure));

        /*  Test 2 */
        principalAmount = 120000;
        interest = 8.2f;
        tenure = 24;
        expected = 5438;
        assertEquals(expected, Loan.calculateEMI(principalAmount, interest, tenure));

        /*  Test 3 */
        principalAmount = 2000000;
        interest = 6.8f;
        tenure = 2;
        expected = 1008521;
        assertEquals(expected, Loan.calculateEMI(principalAmount, interest, tenure));

        /*  Test 4 */
        principalAmount = 0;
        interest = 0;
        tenure = 24;
        expected = -1;
        assertEquals(expected, Loan.calculateEMI(principalAmount, interest, tenure));
    }

    @org.junit.jupiter.api.Test
    void getTotalPayment() {

        /*  Test 1  */
        int tenure = 12;
        int expected = 5288928;
        int emi = 440744;
        assertEquals(expected, Loan.getTotalPayment(emi, tenure));

        /*  Test 2  */
        tenure = 24;
        emi = 5438;
        expected = 130512;
        assertEquals(expected, Loan.getTotalPayment(emi, tenure));

        /*  Test 3  */
        tenure = 24;
        emi = 89364;
        expected = 2144736;
        assertEquals(expected, Loan.getTotalPayment(emi, tenure));

        /*  Test 4  */
        tenure = 0;
        emi = 89364;
        expected = -1;
        assertEquals(expected, Loan.getTotalPayment(emi, tenure));
    }

    @org.junit.jupiter.api.Test
    void getTotalInterestPayable() {

        /*  Test 1  */
        int principalAmount = 5000000;
        int totalPay = 5288928;
        int expected = 288928;
        assertEquals(expected, Loan.getTotalInterestPayable(principalAmount, totalPay));

        /*  Test 2  */
       /* principalAmount = 1200000;
        totalPay = 130512;
        expected = 10512;
        assertEquals(expected, Loan.getTotalInterestPayable(principalAmount, totalPay));*/

        /*  Test Null  */
        principalAmount = 2000000;
        totalPay = 2144736;
        expected = 144736;
        assertEquals(expected, Loan.getTotalInterestPayable(principalAmount, totalPay));

        /*  Test 3  */
        principalAmount = 0;
        totalPay = 2144736;
        expected = -1;
        assertEquals(expected, Loan.getTotalInterestPayable(principalAmount, totalPay));

    }
}