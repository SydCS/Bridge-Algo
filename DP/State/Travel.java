import java.util.Arrays;
import java.util.Scanner;

// https://www.acwing.com/problem/content/733/
public class Travel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] w = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                w[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        // 状态表示：dp[s,j]
        // 集合：s表示当前已经遍历过的城市（n位二进制），最后到达j
        // 属性：集合中每个方案的最小花费
        int states = 1 << n;
        int[][] dp = new int[states][n];
        for (int i = 0; i < states; i++) {
            Arrays.fill(dp[i], 0x3f3f3f3f);
        }
        dp[1][0] = 0;

        // 状态计算：划分
        // dp[s,j] = min{dp[s/{j},k] + w[k,j]} for k in s/{j}
        for (int s = 3; s < states; s += 2) { // 优化：s末位必为1
            for (int j = 0; j < n; j++) {
                if (((s >> j) & 1) == 0) // 当前集合必须包含j
                    continue;

                // 枚举子集
                for (int k = 0; k < n; k++) {
                    if ((((s - (1 << j)) >> k) & 1) == 1) { // 当前集合去掉j后包含k
                        dp[s][j] = Math.min(dp[s][j], dp[s - (1 << j)][k] + w[k][j]);
                    }
                }
            }
        }

        // 枚举所有最后到达的城市
        int min = 0x3f3f3f3f;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, dp[states - 1][j] + w[j][0]);
        }
        System.out.println(min);
    }
}
