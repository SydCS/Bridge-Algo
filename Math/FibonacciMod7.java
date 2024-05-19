import java.util.Scanner;

// https://acm.hdu.edu.cn/showproblem.php?pid=1005
public class FibonacciMod7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int A = scanner.nextInt(), B = scanner.nextInt(), n = scanner.nextInt();
            if (A == 0 && B == 0 && n == 0)
                break;

            n = n % 49;
            System.out.println(fibMod(A, B, n));
        }
        scanner.close();
    }

    private static int fibMod(int A, int B, int n) {
        if (n == 1 || n == 2)
            return 1;

        return (A * fibMod(A, B, n - 1) + B * fibMod(A, B, n - 2)) % 7;
    }
}
