public class Matrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };

        int determinant = calculateDeterminant(matrix);

        System.out.println("Determinant of the matrix is: " + determinant);
    }

    public static int calculateDeterminant(int[][] matrix) {
        if (matrix.length != 2 || matrix[0].length != 2 || matrix[1].length != 2) {
            System.out.println("Matrix must be 2x2");
            return 0; // یک مقدار خروجی انتخاب کنید یا به دیگری ادامه دهید
        }

        int a = matrix[0][0];
        int b = matrix[0][1];
        int c = matrix[1][0];
        int d = matrix[1][1];

        int determinant = (a * d) - (b * c);

        return determinant;
    }
}
