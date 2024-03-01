import java.util.Arrays;
import java.util.Scanner;

public class MoveDorm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 物品总数
        int k = scanner.nextInt(); // 要选择的对数

        int[] weights = new int[n + 1]; // 重量数组，从1开始计数，0位置不使用
        for (int i = 1; i <= n; i++) {
            weights[i] = scanner.nextInt();
        }

        // 对重量数组进行排序
        Arrays.sort(weights);

        // 初始化DP数组
        int[][] dp = new int[n + 1][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[0][0] = 0; // 初始化条件
        dp[1][0] = 0;

        // 填充DP表
        for (int i = 2; i <= n; i++) {
            dp[i][0] = 0; // 从i件物品中选择0对，疲劳度为0
            for (int j = 1; j <= k && 2 * j <= i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j],
                        dp[i - 2][j - 1] + (weights[i] - weights[i - 1]) * (weights[i] - weights[i - 1]));
            }
        }

        System.out.println(dp[n][k]);
        scanner.close();
    }
}
