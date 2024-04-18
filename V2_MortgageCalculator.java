package amalitech;

import java.text.NumberFormat;
import java.util.Scanner;

public class V2_MortgageCalculator {


    public static void main(String... args) {

        /**
         * Constants
         * <p>
         *  MONTHS_IN_YEAR
         * PERCENT
         */
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        System.out.println("Welcome to the Mortgage calculator!");
         //getPrincipal();
        int principal = getPrincipal();
        System.out.println("Principal: " + principal);
         //getAnnualInterestRate();
        float annualInterestRate = getAnnualInterestRate();
        System.out.println("Annual Interest Rate: " + annualInterestRate);
        // monthlyInterest
        float monthlyInterest = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        System.out.println("Monthly Interest Rate: " + monthlyInterest);
        // getLoanTermYears();
        int loanTermYears = getLoanTermYears();
        System.out.println("Period (Years): " + loanTermYears);
          // numberOfPayments
        int numberOfPayments = loanTermYears * MONTHS_IN_YEAR;
        System.out.println("Number of Payments: " + numberOfPayments);
        /**
         * Calculate the mortgage
         * <p>
         *  principal
         * monthlyInterest
         * numberOfPayments
         * mortgage
         * mortgageFormatted
         */
        double mortgage = calculateMortgage(principal, monthlyInterest, numberOfPayments);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);

    }

    /**
     * Get the principal
     * <p>
     *  Scanner
     * return
     */

    private static int getPrincipal() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Principal:");
                int principal = Integer.parseInt(scanner.next());
                if (principal > 1000 && principal <= 1_000_000)
                    return principal;
                System.out.println("Enter a value between 1000 and 1000000");
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number");
            }
        }
    }

    /**
     * Get the annual interest rate
     * <p>
     *  Scanner
     * return
     */
    private static float getAnnualInterestRate() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Annual Interest Rate:");
                float annualInterestRate = Float.parseFloat(scanner.next());
                if (annualInterestRate > 0)
                    return annualInterestRate;
                System.out.println("Enter a valid positive interest rate");
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number");
            }
        }
    }

    /**
     * Get the loan term in years
     * <p>
     *  Scanner
     * return
     */

    private static int getLoanTermYears() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Period (Years):");
                int loanTermYears = Integer.parseInt(scanner.next());
                if (loanTermYears > 0)
                    return loanTermYears;
                System.out.println("Enter a valid positive number of years");
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number");
            }
        }
    }

    /**
     * Calculate the mortgage
     * <p>
     *  Principal
     * monthlyInterest
     * numberOfPayments
     * return
     */

    private static double calculateMortgage(int principal, float monthlyInterest, int numberOfPayments) {
        return principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

}
