import java.util.Arrays;

// https://www.acwing.com/file_system/file/content/whole/index/content/3067/
public class Fibonacci {
    private static int[] memo;

    public static void main(String[] args) {
        final int n = 7;

        System.out.println(fibRecursive(n));

        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        System.out.println(fibMemoization(n));

        System.out.println(fibDynamicProgramming(n));

        System.out.println(fibMatrixFastExponentiation(n));
    }

    // O(2 ^ n)
    public static int fibRecursive(int n) {
        if (n <= 1)
            return n;

        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    // O(n)
    public static int fibMemoization(int n) {
        if (n <= 1)
            return n;

        if (memo[n] != -1)
            return memo[n];

        memo[n] = fibMemoization(n - 1) + fibMemoization(n - 2);
        return memo[n];
    }

    // O(n)
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

    // O(\log n)
    public static int fibMatrixFastExponentiation(int n) {
        if (n <= 1)
            return n;

        int[][] result = { { 1, 0 }, { 0, 0 } };
        int[][] fibMatrix = { { 1, 1 }, { 1, 0 } };

        // 矩阵快速幂
        while (n > 0) {
            if (n % 2 == 1) {
                result = multiply(result, fibMatrix);
            }
            fibMatrix = multiply(fibMatrix, fibMatrix);
            n >>= 1;
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
