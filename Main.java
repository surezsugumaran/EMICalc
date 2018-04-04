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
              float interest = loan.getInterest(loanType);

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

              if(emi == -1)
              {
                  System.out.println("Some of the values you've entered is incorrect!!!");
                  System.exit(0);
              }

              /* Get Total Payment */
              int totalPay = loan.getTotalPayment(emi, tenure);

              if(totalPay == -1)
              {
                  System.out.println("Some of the values you've entered is incorrect!!!");
                  System.exit(0);
              }

              /*  Get total Interest Payable */
              int interestPayable = loan.getTotalInterestPayable(principalAmount, totalPay);

              if(interestPayable == -1)
              {
                  System.out.println("Some of the values you've entered is incorrect!!!");
                  System.exit(0);
              }

              System.out.println("The EMI for your Principal and tenure is:");
              System.out.println(formatter.format(new BigDecimal(emi)));

              System.out.println("Your total interest Payable to bank:");
              System.out.println(formatter.format(new BigDecimal(interestPayable)));

              System.out.println("Your total Payment is:");
              System.out.println(formatter.format(new BigDecimal(totalPay))+"\n");

          } else if (userOrAdmin.equals("admin")) {

              System.out.println("Hi! Admin");
              System.out.println("Do You want to change interest type:Enter (yes/no):->");
              String yesOrNo = sc.next().toLowerCase();

              if (yesOrNo.equals("yes")) {

                  System.out.println("Enter the Type of loan you want to change:" +
                          " Either Home or Car or Personal");
                  String loanType = sc.next().toLowerCase();

                  /* Get Interest for loan type  */
                  float presentInterest = loan.getInterest(loanType);

                  if(presentInterest==-1.0f)
                  {
                      System.exit(0);
                  }

                  System.out.println("The Present interest rate of " + loanType + " " +
                          "is" + presentInterest + "" +
                          " \nTo What would you like to change it to!!");
                  float interest = sc.nextFloat();

                  int flag = loan.setUpdatedInterest(interest, loanType);


                  if(flag == 1)
                  {
                      System.exit(0);
                  }
                  System.out.println("Your Interest rates have been updated!!");

                  float updatedInterest = loan.getInterest(loanType);
                  System.out.println("Updated Interest is " + updatedInterest+"\n");

              } else if(yesOrNo.equals("no")){
                  System.out.println("These are the Interest rates of loans");
                  System.out.println("Home Loan Interest :->" + loan.getHomeLoanInterest() + "\n");
                  System.out.println("Car Loan Interest :->" + loan.getCarLoanInterest() + "\n");
                  System.out.println("Personal Loan Interest :->" + loan.getPersonalLoanInterest() + "\n");
                  System.out.println("Thank You then!\n");
              }
              else
              {
                  System.out.println("You have chosed an incorrect option!!!");
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
}
