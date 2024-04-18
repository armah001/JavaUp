package amalitech;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
public class ParallenMatrixTimes extends RecursiveTask<int[][]>{
    private static final int THRESHOLD = 100;
    private final int[][] matrix1;
    private final int[][] matrix2;
    private final int start;
    private final int end;

    public ParallenMatrixTimes(int[][] matrix1, int[][] matrix2, int start, int end) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.start = start;
        this.end = end;

    }
    @Override
    protected int[][] compute() {
        int rows = end - start;
        if (rows <= THRESHOLD) {
            return multiplyDirectly();
        } else {
            int mid = start + rows / 2;
            ParallenMatrixTimes task1 = new ParallenMatrixTimes(matrix1, matrix2, start, mid);
            ParallenMatrixTimes task2 = new ParallenMatrixTimes(matrix1, matrix2, mid, end);
            task1.fork();
            int[][] result1 = task2.compute();
            int[][] result2 = task1.join();
            return combineResults(result1, result2);
        }
    }

    private int[][] multiplyDirectly() {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;
        int[][] result = new int[rows1][cols2];
        for (int i = start; i < end; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    private int[][] combineResults(int[][] result1, int[][] result2) {
        int[][] result = new int[result1.length + result2.length][];
        System.arraycopy(result1, 0, result, 0, result1.length);
        System.arraycopy(result2, 0, result, result1.length, result2.length);
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix1 = new int[3][3];
        int[][] matrix2 = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix1[i][j] = i + j;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix2[i][j] = i - j;
            }
        }

        ForkJoinPool pool = new ForkJoinPool();
        ParallenMatrixTimes task = new ParallenMatrixTimes(matrix1, matrix2, 0, matrix1.length);
        int[][] result = pool.invoke(task);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
