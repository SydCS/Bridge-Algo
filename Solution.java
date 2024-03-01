class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        int[] dp = new int[n + 1];
        // dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], questions[i][0] + dp[Math.min(i + questions[i][1] + 1, n)]);
        }
        return dp[0];
    }
}