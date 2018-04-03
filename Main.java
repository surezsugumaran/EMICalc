package com.company;

import java.math.BigDecimal;

import java.text.Format;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);

	  String userOrAdmin = "";
	  int flag2 = 0;
	  Loan loan = new Loan();
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));

        while(!userOrAdmin.equals("logout")) {

          System.out.println("Enter User Or Admin Or LogOut:");
	      userOrAdmin = sc.next().toLowerCase();

          if (userOrAdmin.equals("user")) {

              System.out.println("Enter the loan type required: Either Home or Car or Personal");
              String loanType = sc.next().toLowerCase();

              /* Get Interest for loan type  */
              float interest = getInterest(loanType, loan);

              if(interest==-1.0f)
              {
                  System.exit(0);
              }

              System.out.println("Enter Principal Amount:");
              int principalAmount = sc.nextInt();

              System.out.println("Enter Tenure period for the amount:");
              int tenure = sc.nextInt();

              System.out.println("The interest for your loan type is:" + interest);

              /*  Calculate EMI  */
              int emi = loan.calculateEMI(principalAmount, interest, tenure);

              /* Get Total Payment */
              int totalPay = loan.getTotalPayment(principalAmount, emi, tenure);

              /*  Get total Interest Payable */
              int interestPayable = loan.getTotalInterestPayable(principalAmount, totalPay);

              System.out.println("The EMI for your Principal and tenure is:");
              System.out.println(formatter.format(new BigDecimal(emi)));

              System.out.println("Your total interest Payable to bank:");
              System.out.println(formatter.format(new BigDecimal(interestPayable)));

              System.out.println("Your total Payment is:");
              System.out.println(formatter.format(new BigDecimal(totalPay))+"\n");

          } else if (userOrAdmin.equals("admin")) {

              System.out.println("Hi! Admin");
              System.out.println("Do You want to change interest type:");
              String yesOrNo = sc.next().toLowerCase();

              if (yesOrNo.equals("yes")) {

                  System.out.println("Enter the Type of loan you want to change:" +
                          " Either Home or Car or Personal");
                  String loanType = sc.next().toLowerCase();

                  /* Get Interest for loan type  */
                  float presentInterest = getInterest(loanType, loan);

                  if(presentInterest==-1.0f)
                  {
                      System.exit(0);
                  }

                  System.out.println("The Present interest rate of " + loanType + " " +
                          "is" + presentInterest + "" +
                          " \nTo What would you like to change it to!!");
                  float interest = sc.nextFloat();

                  int flag = setUpdatedInterest(interest, loanType, loan);
                  System.out.println("Your Interest rates have been updated!!");

                  if(flag == 1)
                  {
                      System.exit(0);
                  }

                  float updatedInterest = getInterest(loanType, loan);
                  System.out.println("Updated Interest is " + updatedInterest+"\n");

              } else {
                  System.out.println("These are the Interest rates of loans");
                  System.out.println("Home Loan Interest :->" + loan.getHomeLoanInterest() + "\n");
                  System.out.println("Car Loan Interest :->" + loan.getCarLoanInterest() + "\n");
                  System.out.println("Personal Loan Interest :->" + loan.getPersonalLoanInterest() + "\n");
                  System.out.println("Thank You then!\n");
              }

          }
          else {
              if(!userOrAdmin.equals("logout"))
              {
                  System.out.println("Sorry!! Unauthorized Access!!!\nTry again\n");
              }
              else
              {
                   flag2 = 1;
                   break;
              }
          }
      }
      if(flag2 == 1)
      System.out.println("You are logged Out!!!");

    }

    public static float getInterest(String loanType, Loan loan){

        float interest = 0.0f;

        switch (loanType)
        {
            case "home":
                interest = loan.getHomeLoanInterest();
                break;
            case "car":
                interest = loan.getCarLoanInterest();
                break;
            case "personal":
                interest = loan.getPersonalLoanInterest();
                break;
            default:
                System.out.println("The loan type you preferred is not here!!!\n");
               // System.exit(0);
                interest = -1.0f;
        }
        return interest;
    }

    public static int setUpdatedInterest(float interest,String loanType,Loan loan){

        int flag = 0;

        switch (loanType)
        {
            case "home":
                loan.setHomeLoanInterest(interest);
                break;
            case "car":
                loan.setCarLoanInterest(interest);
                break;
            case "personal":
                loan.setPersonalLoanInterest(interest);
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
