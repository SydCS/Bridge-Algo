import java.util.Scanner;

public class LCM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            int lcm = 1;

            for (int j = 0; j < m; j++) {
                int number = scanner.nextInt();
                lcm = lcm(lcm, number);
            }
            System.out.println(lcm);
        }

        scanner.close();
    }

    private static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b; // 先除
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    private static int gcdRecur(int a, int b) {
        return b == 0 ? a : gcdRecur(b, a % b);
    }
}
