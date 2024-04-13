import java.util.Scanner;

// https://www.luogu.com.cn/problem/P1313
public class Coefficient {
    static final int MOD = 10007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt(), b = scanner.nextInt(), k = scanner.nextInt(),
                n = scanner.nextInt(), m = scanner.nextInt();
        scanner.close();

        // 系数：C(k,n) a^n b^m

        // 求组合数：递推 O(n^2)
        // C(a,b) = C(a-1,b-1) + C(a-1,b)
        int[][] C = new int[k + 1][k + 1];
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0)
                    C[i][j] = 1;
                else
                    C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % MOD;
            }
        }

        long coefficient = C[k][n];
        for (int i = 0; i < n; i++)
            coefficient = (coefficient * a) % MOD;
        for (int i = 0; i < m; i++)
            coefficient = (coefficient * b) % MOD;
        System.out.println(coefficient);
    }
}
