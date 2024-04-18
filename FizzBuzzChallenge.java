package amalitech;

import java.util.Scanner;

public class FizzBuzzChallenge {
    public static void main(String... args) {

        Scanner scanner = new Scanner(System.in);
        //Example #1: What specific problem are in this code?

        System.out.println("Number:");
        int number = scanner.nextInt();
        if (number % 5 == 0) {
            System.out.println("Fizz");

        } else if (number % 3 == 0) {
            System.out.println("Buzz");
        } else if (number % 5 == 0 && number % 3 == 0) {
            System.out.println("FizzBuzz");

        } else {
            System.out.println(number);
        }

        /*The condition for checking if the number is divisible by both 5 and 3 (FizzBuzz) is placed after
        checking if the number is divisible by 5 (Fizz) and by 3 (Buzz). As a result, the "FizzBuzz" condition
        will never be reached, because any number that is divisible by both 5 and 3 will already satisfy the
        conditions for "Fizz" or "Buzz" individually.
        To fix this, you should move the condition for checking if the number is divisible by both 5 and 3 to the top,
        before the individual checks for divisibility by 5 and 3.*/


        //Example #2: How Can we improve this code?
        //By placing most specific on top and most generic on bottom
        //This block of code has a bit of repletion?
        //Does this block of code has a flat structure without nesting? T
        //This code is cleaner and easier to read?


//
        System.out.println("Number:");
        int numberTwo = scanner.nextInt();


        if (numberTwo % 5 == 0 && numberTwo % 3 == 0) {
            System.out.println("FizzBuzz");
        } else if (numberTwo % 5 == 0) {
            System.out.println("Fizz");
        } else if (numberTwo % 3 == 0) {
            System.out.println("Buzz");

        } else {
            System.out.println(numberTwo);
        }


//        boolean isFizzBuzz = (numberTwo % 5 == 0 && numberTwo % 3 == 0);
//        boolean isFizz = (numberTwo % 5 == 0);
//        boolean isBuzz = (numberTwo % 3 == 0);
//        if (isFizzBuzz) {
//            System.out.println("FizzBuzz");
//        } else if (isFizz) {
//            System.out.println("Fizz");
//        } else if (isBuzz) {
//            System.out.println("Buzz");
//        } else {
//            System.out.println(numberTwo);
//        }


//        //Can we apply DRY- don’t repeat yourself principle??
        System.out.println("Number:");
        int numberThree = scanner.nextInt();
        if (numberThree % 5 == 0) {
            if (numberThree % 3 == 0) {
                System.out.println("FizzBuzz");
            } else
                System.out.println("Fizz");

        }
        /*
        We can remove this for to adhere to DRY principle
        else if(numberThree%5==0){
        System.out.println("Fizz");
        */
        else if (numberThree % 3 == 0) {
            System.out.println("Buzz");

        } else
            System.out.println(numberThree);


        //  ternary operator
        System.out.println("Number:");
        int number5 = scanner.nextInt();

        String result = (number5 % 5 == 0 && number5 % 3 == 0) ? "FizzBuzz" :
                (number5 % 5 == 0) ? "Fizz" : (number5 % 3 == 0) ? "Buzz" : String.valueOf(number5);
        System.out.println(result);

        //  ternary operator
        System.out.println("Number:");
        int num = scanner.nextInt();
        boolean isFizz = num % 5 == 0;
        boolean isBuzz = num % 3 == 0;
        String result2 = (isFizz && isBuzz) ? "FizzBuzz" : (isFizz) ? "Fizz" :
                (isBuzz) ? "Buzz" : String.valueOf(num);
        // String.valueOf(num);
        //Integer.toString(num);
        System.out.println(result2);

    }
}

/**
 * Note:
 * 1. Nested If are considered bad practices?
 * 2. This is not terribly bad—the more we nest the more confusing the code become—to other people
 * 3. The more we build the more we realize that there is no way to build ideal software
 * 4. Programming and problem-solving always a trade-offs
 * 5. Every solution has a degree of strength, and weakness
 * 6. Not having repetition but duplication??
 * 7. But having nested structure that make the code had and read and understand would be really ideal?
 */
