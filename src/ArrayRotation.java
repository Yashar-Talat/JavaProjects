import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();
        int rotations = scanner.nextInt();

        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }

        rotateArray(array, rotations);
        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void rotateArray(int[] arr, int rotations) {
        int length = arr.length;
        rotations = ((rotations % length) + length) % length;
        int[] temp = new int[length];

        for (int i = 0; i < rotations; i++) {
            temp[i] = arr[length - rotations + i];
        }

        for (int i = rotations; i < length; i++) {
            temp[i] = arr[i - rotations];
        }

        for (int i = 0; i < length; i++) {
            arr[i] = temp[i];
        }
    }
}
