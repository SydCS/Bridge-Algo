import java.util.Scanner;

// https://www.luogu.com.cn/problem/P9232
public class Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.next();
        int n = num.length();

        int count = 0;
        // 暴力 O(n^3)
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int l = i, r = j; l < r; l++, r--) {
                    if (num.charAt(l) > num.charAt(r)) {
                        count++;
                        break;
                    } else if (num.charAt(l) < num.charAt(r)) {
                        break;
                    }
                }
            }
        }

        // 区间DP O(n^2)
        int[][] dp = new int[n][n]; // dp[i][j] 表示反转从i到j的子串是否符合条件
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (num.charAt(i) > num.charAt(j)) {
                    dp[i][j] = 1;
                } else if (num.charAt(i) == num.charAt(j)) {
                    if (i + 1 <= j - 1) {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
        scanner.close();
    }
}
