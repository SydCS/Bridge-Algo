import java.util.Scanner;

public class BashGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int games = sc.nextInt();
        while (games-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();

            if (n % (m + 1) == 0)
                System.out.println("second");
            else
                System.out.println("first");
        }
        sc.close();
    }
}
