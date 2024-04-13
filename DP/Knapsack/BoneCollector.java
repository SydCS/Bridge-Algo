import java.util.Scanner;

// https://acm.hdu.edu.cn/showproblem.php?pid=2602
public class BoneCollector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt(), V = scanner.nextInt();

            int[] values = new int[N], volumns = new int[N];
            for (int i = 0; i < N; i++) {
                values[i] = scanner.nextInt();
            }
            for (int i = 0; i < N; i++) {
                volumns[i] = scanner.nextInt();
            }

            // 01 背包
            int[] dp = new int[V + 1];
            for (int i = 0; i < N; i++) {
                for (int j = V; j >= volumns[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - volumns[i]] + values[i]);
                }
            }
            System.out.println(dp[V]);
        }
        scanner.close();
    }
}
