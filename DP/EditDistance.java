import java.util.Scanner;

// https://www.luogu.com.cn/problem/P2758
public class EditDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next(), s2 = scanner.next();
        int n1 = s1.length(), n2 = s2.length();
        scanner.close();

        int[][] dp = new int[n1 + 1][n2 + 1]; // 到第 i j 个字符的最短编辑距离
        for (int i = 0; i <= n1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n2; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
            }
        }
        System.out.println(dp[n1][n2]);
    }
}
