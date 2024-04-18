package amalitech;
import java.util.ArrayList;
public class Lambda1 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(8);
        numbers.remove(2);
        numbers.forEach((n) -> {
            System.out.println(n);
        });

    }
}
