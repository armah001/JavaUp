package amalitech;

import java.util.Arrays;
import java.util.List;

public class Lambda2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Using lambda expression to print all elements of numbers list
        System.out.println("All numbers:");
        numbers.forEach(number -> System.out.println(number));

        // Using lambda expression to print even numbers from the list
        System.out.println("Even numbers:");
        numbers.stream()
                .filter(number -> number % 2 == 0)
                .forEach(System.out::println);
    }
}