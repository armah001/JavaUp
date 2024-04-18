package amalitech;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MortgageCalculator_NT {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        MortgageCalculators mortgageCalculator = new MortgageCalculators();
        InputValidator inputValidator = new InputValidator();

        double principal = inputValidator.getDoubleInput(ui, "Enter the principal:");
        float annualInterestRate = inputValidator.getFloatInput(ui, "Enter the annual interest rate:");
        int numberOfYears = inputValidator.getIntInput(ui, "Enter the number of years:");

        double mortgage = mortgageCalculator.calculateMortgage(principal, annualInterestRate, numberOfYears);

        ui.displayMortgage(mortgage);
    }
}

class UserInterface {
    private Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    public double getDoubleInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextDouble();
    }

    public float getFloatInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextFloat();
    }

    public int getIntInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextInt();
    }

    public void displayMortgage(double mortgage) {
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }

    public void displayError(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }

    public void clearBuffer() {
        scanner.nextLine();
    }
}

class InputValidator {
    public double getDoubleInput(UserInterface ui, String prompt) {
        while (true) {
            try {
                return ui.getDoubleInput(prompt);
            } catch (InputMismatchException e) {
                ui.displayError("Invalid input. Please enter a valid number.");
                ui.clearBuffer();
            }
        }
    }

    public float getFloatInput(UserInterface ui, String prompt) {
        while (true) {
            try {
                return ui.getFloatInput(prompt);
            } catch (InputMismatchException e) {
                ui.displayError("Invalid input. Please enter a valid number.");
                ui.clearBuffer();
            }
        }
    }

    public int getIntInput(UserInterface ui, String prompt) {
        while (true) {
            try {
                return ui.getIntInput(prompt);
            } catch (InputMismatchException e) {
                ui.displayError("Invalid input. Please enter a valid integer.");
                ui.clearBuffer();
            }
        }
    }
}

class MortgageCalculators {
    private static final int PERCENT = 100;
    private static final int MONTHS_IN_YEAR = 12;

    public double calculateMortgage(double principal, float annualInterestRate, int numberOfYears) {
        double monthlyInterest = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        int numberOfPayments = numberOfYears * MONTHS_IN_YEAR;

        return principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }
}
