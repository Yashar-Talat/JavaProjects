import java.util.Scanner;

public class Matrix {
    int[][] a;
    int[][] b;

    public void fillMatrixA(int[][] array) {
        a = array;
    }

    public void fillMatrixB(int[][] array) {
        b = array;
    }

    public void addAB() {
        if (validateMatrixDimensions()) {
            int rows = a.length;
            int cols = a[0].length;
            int[][] result = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    result[i][j] = a[i][j] + b[i][j];
                }
            }

            printMatrix(result);
        } else {
            System.out.println("Cannot perform addition. Matrix dimensions are not equal.");
        }
    }

    public void subtractAB() {
        if (validateMatrixDimensions()) {
            int rows = a.length;
            int cols = a[0].length;
            int[][] result = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    result[i][j] = a[i][j] - b[i][j];
                }
            }

            printMatrix(result);
        } else {
            System.out.println("Cannot perform subtraction. Matrix dimensions are not equal.");
        }
    }

    public void multiply() {
        int rowsA = a.length;
        int colsA = a[0].length;
        int rowsB = b.length;
        int colsB = b[0].length;

        if (colsA == rowsB) {
            int[][] result = new int[rowsA][colsB];

            for (int i = 0; i < rowsA; i++) {
                for (int j = 0; j < colsB; j++) {
                    for (int k = 0; k < colsA; k++) {
                        result[i][j] += a[i][k] * b[k][j];
                    }
                }
            }

            printMatrix(result);
        } else {
            System.out.println("Cannot perform multiplication. Matrix dimensions are not compatible.");
        }
    }

    public boolean validateMatrixDimensions() {
        return a.length == b.length && a[0].length == b[0].length;
    }

    private void printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        System.out.println("Resultant Matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create Matrix object
        Matrix m1 = new Matrix();

        // Fill Matrix A
        System.out.println("Enter the number of rows for Matrix A:");
        int rowsA = scanner.nextInt();
        System.out.println("Enter the number of columns for Matrix A:");
        int colsA = scanner.nextInt();
        int[][] arrayA = new int[rowsA][colsA];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                System.out.print("Enter element at position [" + i + "][" + j + "]: ");
                arrayA[i][j] = scanner.nextInt();
            }
        }
        m1.fillMatrixA(arrayA);

        // Fill Matrix B
        System.out.println("Enter the number of rows for Matrix B:");
        int rowsB = scanner.nextInt();
        System.out.println("Enter the number of columns for Matrix B:");
        int colsB = scanner.nextInt();
        int[][] arrayB = new int[rowsB][colsB];
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                System.out.print("Enter element at position [" + i + "][" + j + "]: ");
                arrayB[i][j] = scanner.nextInt();
            }
        }
        m1.fillMatrixB(arrayB);
        // Perform operations
        System.out.println("--------------------------------------");
        System.out.println("Performing Matrix Addition:");
        m1.addAB();

        System.out.println("\nPerforming Matrix Subtraction:");
        m1.subtractAB();

        System.out.println("\nPerforming Matrix Multiplication:");
        m1.multiply();
        scanner.close();
    }
}
