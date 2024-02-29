import java.util.Arrays;

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0x3f3f3f3f);
        dp[0] = 0;
        for (int t = 1; t * t <= n; t++) {
            int x = t * t;
            for (int j = x; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - x] + 1);
            }
        }
        return dp[n];
    }
}
