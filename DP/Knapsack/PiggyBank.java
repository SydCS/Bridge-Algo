import java.util.Arrays;
import java.util.Scanner;

// https://acm.hdu.edu.cn/showproblem.php?pid=1114
public class PiggyBank {
    static int INF = 0x3f3f3f3f;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int E = scanner.nextInt(), F = scanner.nextInt();
            int W = F - E; // Maximum weight that can be added to the piggy bank

            int N = scanner.nextInt();
            int[] v = new int[505], w = new int[505];
            for (int i = 0; i < N; i++) {
                v[i] = scanner.nextInt();
                w[i] = scanner.nextInt();
            }

            // 完全背包 恰好装满
            int[] dp = new int[10010];
            Arrays.fill(dp, INF); // 求最小值时，初始化为无穷大 0x3f3f3f3f
            dp[0] = 0;

            for (int i = 0; i < N; i++) {
                for (int j = w[i]; j <= W; j++) {
                    dp[j] = Math.min(dp[j], dp[j - w[i]] + v[i]);
                }
            }

            if (dp[W] != INF) {
                System.out.println("The minimum amount of money in the piggy-bank is " + dp[W] + ".");
            } else {
                System.out.println("This is impossible.");
            }
        }
        scanner.close();
    }
}
