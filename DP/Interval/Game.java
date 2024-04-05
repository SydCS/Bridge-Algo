import java.util.Scanner;

// https://www.luogu.com.cn/problem/P2734
public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] nums = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
            sum += nums[i];
        }

        // 区间DP
        int[][] dp = new int[N][N]; // dp[i][j] 表示区间 [i, j] 中先手得分-后手得分的最大值
        for (int i = 0; i < N; i++) {
            dp[i][i] = nums[i];
        }

        for (int len = 2; len <= N; len++) {
            for (int i = 0; i + len - 1 < N; i++) {
                int j = i + len - 1;
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }

        int diff = dp[0][N - 1];
        System.out.println((sum + diff) / 2 + " " + (sum - diff) / 2);
        scanner.close();
    }
}
