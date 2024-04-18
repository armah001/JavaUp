package amalitech;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;


//Parallel Fibonacci Calculation with Fork/Join Framework
public class Fibonacci extends RecursiveTask<Integer> {
    private final int number;

    public Fibonacci(int number) {
        this.number = number;
    }

    @Override
    protected Integer compute() {
        if (number <= 1) {
            return number;
        }

        Fibonacci task1 = new Fibonacci(number - 1);
        task1.fork();
        Fibonacci task2 = new Fibonacci(number - 2);
        task2.fork();

        return task1.join() + task2.join();
    }


    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();

        int number = 7;
        Fibonacci task = new Fibonacci(number);

        int result = pool.invoke(task);

        System.out.println(result);
    }
}