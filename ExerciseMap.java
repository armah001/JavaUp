package amalitech;

import java.util.HashMap;
import java.util.Map;

public class ExerciseMap {
    public static void main(String[] args) {
        // Create a map
        Map<Integer, String> map = new HashMap<>();

        // Add key-value pairs to the map
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");

        // Print the map
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}