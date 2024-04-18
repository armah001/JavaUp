package amalitech;

import java.util.List;
/**
 * 1. Create a list of 5 elements and print the list
 * 2. Add an element to the list and print the list
 * 3. Remove an element from the list and print the list
 */
import java.util.ArrayList;

public class ExerciseList {
    public static void main(String... args) {
        // 1. Create a list of 5 elements and print the list
        List<String> list = new ArrayList<>();
        list.add("Element 1");
        list.add("Element 2");
        list.add("Element 3");
        list.add("Element 4");
        list.add("Element 5");
        System.out.println("Initial list: " + list);

        // 2. Add an element to the list and print the list
        list.add("Element 6");
        System.out.println("List after adding element 6: " + list);

        // 3. Remove an element from the list and print the list
        list.remove("Element 1");
        System.out.println("List after removing element 1: " + list);
    }
}