import java.util.Scanner;

// https://www.luogu.com.cn/problem/P8646
public class Baozi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] w = new int[N + 1];
        int d = 0; // 所有数的最大公约数
        for (int i = 1; i <= N; i++) {
            w[i] = scanner.nextInt();
            d = gcd(d, w[i]);
        }
        scanner.close();

        // 两个数的组合必定是其 gcd 的倍数
        // gcd = 1 最大的凑不出来的数 ab - a - b
        // gcd >= 2 凑不出来的数有无限多个

        if (d >= 2) {
            System.out.println("INF");
            return;
        }

        // 完全背包

        // boolean dp[][] = new boolean[N + 1][10000]; // 前 i 个数，能否凑出 j
        // dp[0][0] = true;

        // for (int i = 1; i <= N; i++) {
        // for (int j = 0; j < 10000; j++) {
        // // for (int prevJ = j; prevJ >= 0; prevJ -= w[i]) {
        // // dp[i][j] |= dp[i - 1][prevJ];
        // // }

        // dp[i][j] |= dp[i - 1][j];
        // if (j >= w[i]) {
        // dp[i][j] |= dp[i][j - w[i]];
        // }
        // }
        // }

        // 优化空间
        boolean[] dp = new boolean[10000];
        dp[0] = true;

        for (int i = 1; i <= N; i++) {
            for (int j = w[i]; j < 10000; j++) {
                dp[j] |= dp[j - w[i]];
            }
        }

        int count = 0;
        for (int i = 0; i < 10000; i++) {
            if (!dp[i]) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
