import java.util.Scanner;

// https://www.acwing.com/problem/content/description/104/
public class Fencing {
    static int N, F;
    static int[] cows;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        F = scanner.nextInt();
        cows = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            cows[i] = scanner.nextInt();
        }

        // 二分答案 找能达到的平均值
        double l = 1, r = 2000;
        while ((r - l) > 0.00001) {
            double mid = (l + r) / 2.0;
            if (check(mid)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        System.out.println((int) (r * 1000));
        scanner.close();
    }

    private static boolean check(double avg) { // 是否有区间达到平均值avg O(N)
        // 转换为减去平均值后是否有长度>=F的区间的和非负

        double[] t = new double[N + 1]; // 减去平均值后的前缀和
        for (int i = 1; i <= N; i++) {
            t[i] = t[i - 1] + cows[i] - avg;
        }

        double[] dp = new double[N + 1]; // dp[i] 表示前i个前缀和中的最小值
        for (int i = 1; i <= N; i++) {
            dp[i] = Math.min(dp[i - 1], t[i]);
        }

        // 找平均值最大的区间：固定右端，找左侧最小
        for (int i = F; i <= N; i++) {
            if (t[i] - dp[i - F] >= 0) {
                return true;
            }
        }
        return false;
    }
}
