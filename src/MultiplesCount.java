import java.util.Scanner;
public class MultiplesCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] A = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        int[] B = new int[m];
        for (int i = 0; i < m; i++) {
            B[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (A[j] % B[i] == 0) {
                    count++;
                }
            }
            System.out.print(count + " ");
        }
    }
}
