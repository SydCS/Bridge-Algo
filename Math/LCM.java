import java.util.Scanner;

// https://acm.hdu.edu.cn/showproblem.php?pid=1019
public class LCM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            int m = scanner.nextInt();
            int lcm = 1;

            for (int i = 0; i < m; i++) {
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
        // 辗转相除
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
