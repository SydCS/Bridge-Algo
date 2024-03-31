import java.util.Scanner;

// https://leetcode.cn/problems/house-robber/
// https://www.acwing.com/problem/content/5409/
public class Rob {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int len = s.length();

        // int[][] dp = new int[len][2]; // 前i个字符 第i个选/不选 最大价值
        // dp[0][0] = 0;
        // dp[0][1] = s.charAt(0) - 'a' + 1;
        // for (int i = 1; i < len; i++) {
        // dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        // dp[i][1] = dp[i - 1][0] + (s.charAt(i) - 'a' + 1);
        // }
        // System.out.println(Math.max(dp[len - 1][0], dp[len - 1][1]));

        int[] dp = new int[len]; // 前i个字符 最大价值
        dp[0] = s.charAt(0) - 'a' + 1;
        dp[1] = Math.max(dp[0], s.charAt(1) - 'a' + 1);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + s.charAt(i) - 'a' + 1);
        }
        System.out.println(dp[len - 1]);
        scanner.close();
    }
}
