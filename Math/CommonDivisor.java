import java.util.Arrays;
import java.util.Scanner;

// https://www.acwing.com/problem/content/4202/
public class CommonDivisor {
    static int N = 1350;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt(), b = scanner.nextInt();
        scanner.close();

        // 所有的公约数 = 最大公约数 GCD 的所有约数 O(\log n + \sqrt n)
        int gcd = gcd(a, b);
        int[] commonDivisor = new int[N];
        int count = 0;
        for (int i = 1; i <= gcd / i; i++) { // 试除法
            if (gcd % i == 0) {
                commonDivisor[count++] = i;
                if (i != gcd / i) {
                    commonDivisor[count++] = gcd / i;
                }
            }
        }
        Arrays.sort(commonDivisor, 0, count);

        int q = scanner.nextInt();
        while (q-- > 0) {
            int l = scanner.nextInt(), r = scanner.nextInt();
            // 枚举
            boolean flag = false;
            for (int i = count - 1; i >= 0; i--) {
                if (commonDivisor[i] >= l && commonDivisor[i] <= r) {
                    flag = true;
                    System.out.println(commonDivisor[i]);
                    break;
                }
            }
            if (!flag)
                System.out.println(-1);
        }
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
