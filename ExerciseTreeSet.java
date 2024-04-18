package amalitech;
import java.util.TreeSet;
public class ExerciseTreeSet {
    public static void main(String[] args) {
        // Create a TreeSet
        TreeSet<String> treeSet = new TreeSet<>();

        // Add elements to the TreeSet
        treeSet.add("One");
        treeSet.add("Two");
        treeSet.add("Three");
        treeSet.add("Four");

        // Add a duplicate element
        treeSet.add("Five");

        // Print the TreeSet
        System.out.println("TreeSet: " + treeSet);

        // Remove an element
        treeSet.remove("Two");

        // Print the TreeSet after removing an element
        System.out.println("TreeSet after removing an element: " + treeSet);
    }
}