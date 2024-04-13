import java.util.Scanner;

// https://www.luogu.com.cn/problem/P1474
public class MoneySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int V = scanner.nextInt(), N = scanner.nextInt();
        int[] v = new int[V + 1]; // 面值
        for (int i = 1; i <= V; i++) {
            v[i] = scanner.nextInt();
        }
        scanner.close();

        // 完全背包 方案数

        // long[][] dp = new long[V + 1][N + 1]; // 前 i 种货币，凑出 j 元的方案数
        // for (int i = 0; i <= V; i++) {
        // dp[i][0] = 1;
        // }

        // for (int i = 1; i <= V; i++) {
        // for (int j = 1; j <= N; j++) {
        // // 选 0 1 2 ... 个第 i 种货币
        // // for (int prevJ = j; prevJ >= 0; prevJ -= v[i]) {
        // // dp[i][j] += dp[i - 1][prevJ];
        // // }

        // dp[i][j] = dp[i - 1][j];
        // if (j >= v[i]) {
        // dp[i][j] += dp[i][j - v[i]];
        // }
        // }
        // }

        // System.out.println(dp[V][N]);

        // 优化空间
        long[] dp = new long[N + 1];
        dp[0] = 1;

        for (int i = 1; i <= V; i++) {
            for (int j = v[i]; j <= N; j++) {
                dp[j] += dp[j - v[i]];
            }
        }

        System.out.println(dp[N]);
    }
}