import java.util.Scanner;

// https://www.luogu.com.cn/problem/P1880
public class Stone {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] stones = new int[2 * N + 1];
        int[] prefix = new int[2 * N + 1];
        for (int i = 1; i <= N; i++) {
            stones[i] = sc.nextInt();
            prefix[i] = prefix[i - 1] + stones[i];
        }
        for (int i = N + 1; i <= 2 * N; i++) {
            stones[i] = stones[i - N]; // 环形，延拓
            prefix[i] = prefix[i - 1] + stones[i];
        }

        // 区间DP
        // dp[i][j] 表示合并区间 [i, j] 内的石头的最大/最小得分
        // dp[i][j] = max(dp[i][k] + dp[k + 1][j]) + a[i] + ... + a[j]
        int[][] dpMax = new int[2 * N + 1][2 * N + 1];
        int[][] dpMin = new int[2 * N + 1][2 * N + 1];
        for (int len = 2; len <= N; len++) {
            for (int i = 1; i + len - 1 <= 2 * N; i++) {
                int j = i + len - 1;
                dpMax[i][j] = 0xe0e0e0e0;
                dpMin[i][j] = 0x3f3f3f3f;
                for (int k = i; k < j; k++) {
                    dpMax[i][j] = Math.max(dpMax[i][j], dpMax[i][k] + dpMax[k + 1][j]);
                    dpMin[i][j] = Math.min(dpMin[i][j], dpMin[i][k] + dpMin[k + 1][j]);
                }
                dpMax[i][j] += prefix[j] - prefix[i - 1];
                dpMin[i][j] += prefix[j] - prefix[i - 1];
            }
        }

        int max = 0xe0e0e0e0;
        int min = 0x3f3f3f3f;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dpMax[i][i + N - 1]);
            min = Math.min(min, dpMin[i][i + N - 1]);
        }
        System.out.println(min);
        System.out.println(max);
        sc.close();
    }

}
