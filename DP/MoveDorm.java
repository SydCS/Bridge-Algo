import java.util.Arrays;
import java.util.Scanner;

// https://acm.hdu.edu.cn/showproblem.php?pid=1421
public class MoveDorm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 物品总数
        int k = scanner.nextInt(); // 要选择的对数

        int[] weights = new int[n + 1]; // 重量数组
        for (int i = 1; i <= n; i++) {
            weights[i] = scanner.nextInt();
        }
        scanner.close();
        Arrays.sort(weights);

        int[][] dp = new int[n + 1][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, 0x3f3f3f3f);
        }
        dp[0][0] = 0;
        dp[1][0] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = 0; // 从i件物品中选择0对，疲劳度为0
            for (int j = 1; j <= k && 2 * j <= i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j],
                        dp[i - 2][j - 1] + (weights[i] - weights[i - 1]) * (weights[i] - weights[i - 1])); // 不选/选
            }
        }

        System.out.println(dp[n][k]);
    }
}
