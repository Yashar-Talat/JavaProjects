import java.util.Scanner;

public class Metro {
  public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] row1 = input.nextLine().split(" ");
        String[] row2 = input.nextLine().split(" ");

        int pairs = 0;
        for (int i = 0; i < 8; i++) {
            if (row1[i].equals("1") && row2[i].equals("1")) {
                pairs++;
            }
        }

        System.out.println(pairs);
    }
}
