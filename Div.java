package amalitech;

public class Div {

    public static void main(String[] args) {
        //error handling
        System.out.println("The Division is: "+divide(10,0));
    }

    //Method a/b
    public static int divide(int a, int b){
        try {
            return a/b;
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
            return 0; // return a default value
        }
    }
}