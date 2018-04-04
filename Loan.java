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

        if(principalAmount == 0 || interest==0.0f || tenure==0)
        {
         return -1;
        }

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
    public static int getTotalPayment(int emi, int tenure){

        if(emi == 0|| tenure == 0)
        {
            return -1;
        }

        int totalPay=0;

        totalPay = emi * tenure;
        return totalPay;
    }

    public static int getTotalInterestPayable(int principalAmount, int totalPay){

        if(principalAmount == 0|| totalPay == 0)
        {
            return -1;
        }

        int interestPayable = 0;

        interestPayable = totalPay - principalAmount;

        return interestPayable;
    }

    public float getInterest(String loanType){

        float interest = 0.0f;

        switch (loanType)
        {
            case "home":
                interest = getHomeLoanInterest();
                break;
            case "car":
                interest = getCarLoanInterest();
                break;
            case "personal":
                interest = getPersonalLoanInterest();
                break;
            default:
                System.out.println("The loan type you preferred is not here!!!\n");
                // System.exit(0);
                interest = -1.0f;
        }
        return interest;
    }

    public int setUpdatedInterest(float interest, String loanType){

        int flag = 0;

        switch (loanType)
        {
            case "home":
                setHomeLoanInterest(interest);
                break;
            case "car":
                setCarLoanInterest(interest);
                break;
            case "personal":
                setPersonalLoanInterest(interest);
                break;
            default:
                System.out.println("The loan type you preferred is not here!!!\n");
                //System.exit(0);
                flag = 1;
        }

        if(flag == 1)
            return  1;
        else

            return 0;
    }
}
