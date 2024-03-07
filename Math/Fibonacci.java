import java.util.Arrays;

public class Fibonacci {
    private static int[] memo;

    public static void main(String[] args) {
        int n = 2;
        System.out.println(fibRecursive(n));
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        System.out.println(fibMemoization(n));
        System.out.println(fibDynamicProgramming(n));
        System.out.println(fibMatrixFastPower(n));
    }

    public static int fibRecursive(int n) {
        if (n <= 1)
            return n;

        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    public static int fibMemoization(int n) {
        if (memo[n] != -1)
            return memo[n];

        if (n <= 1)
            return n;

        memo[n] = fibMemoization(n - 1) + fibMemoization(n - 2);
        return memo[n];
    }

    public static int fibDynamicProgramming(int n) {
        if (n <= 1)
            return n;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int fibMatrixFastPower(int n) {
        if (n <= 1)
            return n;

        int[][] result = { { 1, 0 }, { 0, 1 } }; // 单位矩阵
        int[][] fibMatrix = { { 1, 1 }, { 1, 0 } };

        while (n > 0) {
            if (n % 2 == 1) {
                result = multiply(result, fibMatrix);
            }
            n /= 2;
            fibMatrix = multiply(fibMatrix, fibMatrix);
        }

        return result[0][1];
    }

    private static int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }
}
