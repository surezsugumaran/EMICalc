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
        String s1 = "Home";
        String s2 = "Car";
        String s3 = "Personal";
        Loan loan = new Loan();

        float expected1 = 10.5f;
        float expected2 = 6.8f;
        float expected3 = 8.2f;
        float expected4 = -1.0f;
        /* Test 1 */
        assertEquals(expected1, Main.getInterest(s1, loan));
        assertEquals(expected2, Main.getInterest(s3, loan));
        assertEquals(expected3, Main.getInterest(s2, loan));
        assertEquals(expected4, Main.getInterest("hi", loan));
    }

    @org.junit.jupiter.api.Test
    void setUpdatedInterest() {
        String s1 = "Home", s2 = "Car", s3 = "Personal";
        Loan loan = new Loan();

        float interest = 0.0f;


        /* Test 1 */
        assertEquals(0, Main.setUpdatedInterest(interest, s1, loan));
        assertEquals(0, Main.setUpdatedInterest(interest, s3, loan));
        assertEquals(0, Main.setUpdatedInterest(interest, s2, loan));
        assertEquals(1, Main.setUpdatedInterest(interest, "hi", loan));
    }

    @org.junit.jupiter.api.Test
    void calculateEMI() {
        int principalAmount1 = 5000000, principalAmount2 = 120000, principalAmount3 = 2000000;
        float interest1 = 10.5f, interest2 = 8.2f, interest3 = 6.8f;
        int tenure1 = 12, tenure2 = 24, tenure3 = 24;

        int expected1 = 440744; // 288928  5288928
        int expected2 = 5438;   //10512   130512
        int expected3 = 89364;  //144736  2144736

        /*  Test 1  */
        assertEquals(expected1, Loan.calculateEMI(principalAmount1, interest1, tenure1));
        assertEquals(expected2, Loan.calculateEMI(principalAmount2, interest2, tenure2));
        assertEquals(expected3, Loan.calculateEMI(principalAmount3, interest3, tenure3));
    }

    @org.junit.jupiter.api.Test
    void getTotalPayment() {
        int principalAmount1 = 5000000, principalAmount2 = 120, principalAmount3 = 2000000;
        int tenure1 = 12, tenure2 = 24, tenure3 = 24;
        int emi1 = 440744, emi2 = 5438, emi3 = 89364;

        int expected1 = 5288928; // 288928
        int expected2 = 130512;   //10512
        int expected3 = 2144736;  //144736
        /*  Test 1  */
        assertEquals(expected1, Loan.getTotalPayment(principalAmount1, emi1, tenure1));
        assertEquals(expected2, Loan.getTotalPayment(principalAmount2, emi2, tenure2));
        assertEquals(expected3, Loan.getTotalPayment(principalAmount3, emi3, tenure3));
    }

    @org.junit.jupiter.api.Test
    void getTotalInterestPayable() {
        int principalAmount1 = 5000000, principalAmount2 = 1200000, principalAmount3 = 2000000;
        int totalPay1 = 5288928, totalPay2 = 130512, totalPay3 = 2144736;

        int expected1 = 288928;
        int expected2 = 10512;
        int expected3 = 144736;

        /*  Test 1  */
        assertEquals(expected1, Loan.getTotalInterestPayable(principalAmount1, totalPay1));
       // assertEquals(expected2, Loan.getTotalInterestPayable(principalAmount2, totalPay2));
        assertEquals(expected3, Loan.getTotalInterestPayable(principalAmount3, totalPay3));

    }
}