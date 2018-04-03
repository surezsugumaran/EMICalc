package com.company;

public class Loan {

    float homeInterest,personalInterest,carInterest;

    Loan(){
    homeInterest = 10.5f;
    personalInterest = 6.8f;
    carInterest = 8.2f;
    }

    public void setHomeLoanInterest(float homeInterest){
        this.homeInterest = homeInterest;
    }

    public void setCarLoanInterest(float carInterest){
        this.carInterest = carInterest;
    }

    public void setPersonalLoanInterest(float personalInterest){
        this.personalInterest = personalInterest;
    }

    public float getHomeLoanInterest(){
        return homeInterest;
    }

    public float getCarLoanInterest(){
        return carInterest;
    }

    public float getPersonalLoanInterest(){
        return personalInterest;
    }

    public static int calculateEMI(int principalAmount, float interest, int tenure){

        int emi;
        float rate = interest/12/100;
       // emi = (int) ((int) principalAmount * rate * ((Math.pow((1+rate),tenure))/(Math.pow((1+rate),tenure))-1));

        float mul = principalAmount * rate;
        float numerator = (float) Math.pow((1+rate),tenure);
        float denominator =  numerator-1;
        float div = numerator/denominator;

        emi = (int) (mul * div);

        return emi;
    }
    public static int getTotalPayment(int principalAmount, int emi, int tenure){

        int totalPay=0;

        totalPay = emi * tenure;
        return totalPay;
    }

    public static int getTotalInterestPayable(int principalAmount, int totalPay){
        int interestPayable = 0;

        interestPayable = totalPay - principalAmount;

        return interestPayable;
    }
}
