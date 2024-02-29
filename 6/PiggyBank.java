import java.util.Arrays;
import java.util.Scanner;

public class PiggyBank {
    public static void main(String[] args) {
        int INF = 0x3f3f3f3f;
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases
        while (T-- > 0) {
            int E = scanner.nextInt();
            int F = scanner.nextInt();
            int W = F - E; // Maximum weight that can be added to the piggy bank

            int N = scanner.nextInt();
            int[] w = new int[505];
            int[] v = new int[505];
            for (int i = 0; i < N; i++) {
                v[i] = scanner.nextInt();
                w[i] = scanner.nextInt();
            }

            int[] dp = new int[10010];
            Arrays.fill(dp, INF); // Initialize dp array to INF to indicate that the states are undefined
            dp[0] = 0; // When the knapsack capacity is 0, the maximum value that can be carried is 0

            for (int i = 0; i < N; i++) {
                for (int j = w[i]; j <= W; j++) {
                    dp[j] = Math.min(dp[j], dp[j - w[i]] + v[i]);
                }
            }

            if (dp[W] != INF) { // If dp[Max] is not INF, a solution exists
                System.out.println("The minimum amount of money in the piggy-bank is " + dp[W] + ".");
            } else {
                System.out.println("This is impossible.");
            }
        }
        scanner.close();
    }
}
