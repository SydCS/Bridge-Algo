import java.util.Scanner;

// 最长回文子序列
// https://www.luogu.com.cn/problem/P8638 
// https://www.luogu.com.cn/problem/P1435
public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int n = s.length();

        // 法1：自身翻转后求 LCS

        // 法2：区间DP
        int[][] dp = new int[n][n]; // dp[i][j] 表示子串 [i, j] 中最长回文子序列的长度
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(n - dp[0][n - 1]);
        scanner.close();
    }
}
