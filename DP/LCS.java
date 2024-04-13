import java.util.Scanner;

// https://www.luogu.com.cn/problem/P1439 
public class LCS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] seq1 = new int[n];
        for (int i = 0; i < n; i++) {
            seq1[i] = scanner.nextInt();
        }
        int[] seq2 = new int[n];
        for (int i = 0; i < n; i++) {
            seq2[i] = scanner.nextInt();
        }
        scanner.close();

        // O(n^2)
        int[][] dp = new int[n + 1][n + 1]; // dp[i][j] 表示到 seq1[i-1] 和 seq2[j-1] 的 LCS 的长度
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (seq1[i - 1] == seq2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[n][n]);

        // O(n \log n)

    }
}
